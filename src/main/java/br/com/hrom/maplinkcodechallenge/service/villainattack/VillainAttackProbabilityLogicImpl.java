package br.com.hrom.maplinkcodechallenge.service.villainattack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.hrom.maplinkcodechallenge.domain.Target;
import br.com.hrom.maplinkcodechallenge.math.probability.ItemProbabilidade;
import br.com.hrom.maplinkcodechallenge.math.probability.ProbabilidadesInversas;

/**
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
@Component
public class VillainAttackProbabilityLogicImpl implements VillainAttackProbabilityLogic {
	
	@Value("${villain.maxProbabilityAttack}")
	private double maxProbabilityAttack;
	
	/**
	 * Calcula a probabilidade de ataque de um vilão a determinados {@link Target}
	 * 
	 * @param targets uma collection contendo os possíveis alvos dos vilões
	 * @return uma lista de alvos com o campo probability preenchido com a probabilidade de ataque de um vilão
	 */
	@Override
	public List<Target> calculeProbability(Collection<Target> targetsToCalculate){		
		List<Target> targets = new ArrayList<>(targetsToCalculate);
		
		//1º Caso: distância de um dos alvos é igual a zero, então tem 95% de chance
		List<Target> targetsWithDistanceZero = targets.stream().filter(target -> target.getDistanceToVillain() == 0.0).collect(Collectors.toList());
		if(targetsWithDistanceZero.size() > 1)
			throw new IllegalArgumentException("There can only be one target with zero distance. However, there are " + targetsWithDistanceZero.size() + ". " + targetsWithDistanceZero);
		
		if(targetsWithDistanceZero.size() == 1){
			return recalculeWithTargetWithMaxProbability(targets, targetsWithDistanceZero.get(0));
		}		
		
		targets = new ProbabilidadesInversas(100.0).calcula(toListOfItemProbabilidade(targets)).stream().map(item -> toTarget(item)).collect(Collectors.toList());
		
		//2º Caso: a probabilidade de ataque de um vilão a um alvo é maior que 95%
		Optional<Target> targetWithProbabilityMax = targets.stream().filter(target -> target.getProbability() > maxProbabilityAttack).findFirst();
		if(targetWithProbabilityMax.isPresent()){
			return recalculeWithTargetWithMaxProbability(targets, targetWithProbabilityMax.get());			
		}
		
		return targets;			
	}
	
	private List<Target> recalculeWithTargetWithMaxProbability(List<Target> targets, Target targetProbabilityMax){
		targetProbabilityMax.setProbability(maxProbabilityAttack);
		targets.remove(targetProbabilityMax);
		
		targets = new ProbabilidadesInversas(100.0 - maxProbabilityAttack)
				.calcula(toListOfItemProbabilidade(targets))
				.stream()
				.map(item -> toTarget(item))
				.collect(Collectors.toList());	
		
		targets.add(targetProbabilityMax);
		
		return targets;
	}

	private Target toTarget(ItemProbabilidade itemProbabilidade){
		Target target = itemProbabilidade.getReferencia(Target.class);
		target.setProbability(itemProbabilidade.getProbabilidade());
		return target;
	}
	
	private List<ItemProbabilidade> toListOfItemProbabilidade(List<Target> targets) {
		return targets.stream().map(target -> new ItemProbabilidade(target.getDistanceToVillain(), target)).collect(Collectors.toList());
	}
}
