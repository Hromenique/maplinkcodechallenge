package br.com.hrom.maplinkcodechallenge.service.villainattack;

import java.util.List;

import br.com.hrom.maplinkcodechallenge.domain.Target;

/**
 * Representa a lógica de cálculo das probabilidades de ataque dos vilões a determinadas alvos 
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public interface VillainAttackProbabilityLogic {

	/**
	 * Calcula a probabilidade de ataque de um vilão a determinados {@link Target}
	 * 
	 * @param targets uma lista contendo os possíveis alvos dos vilões
	 * @return uma lista de alvos com o campo probability preenchido com a probabilidade de ataque de um vilão
	 */
	List<Target> calculeProbability(List<Target> targets);

}