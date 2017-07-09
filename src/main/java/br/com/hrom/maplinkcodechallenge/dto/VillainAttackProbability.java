package br.com.hrom.maplinkcodechallenge.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.hrom.maplinkcodechallenge.domain.Target;
import br.com.hrom.maplinkcodechallenge.domain.Villain;

/**
 * Resposta do BatComputador contendo os dados de probabilidade de ataque de um
 * vilão a determinados alvos
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
@JsonPropertyOrder(value={"villain", "targets"})
public class VillainAttackProbability {

	private Villain villain;
	private List<Target> targets;

	public VillainAttackProbability(Villain villain, List<Target> targets) {
		super();
		this.villain = villain;
		this.targets = targets;
	}

	public Villain getVillain() {
		return villain;
	}

	public void setVillain(Villain villain) {
		this.villain = villain;
	}

	public void addTarget(Target target) {
		targets.add(target);
	}

	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

}
