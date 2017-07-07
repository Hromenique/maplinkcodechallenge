package br.com.hrom.maplinkcodechallenge.dto;

import java.util.List;

import br.com.hrom.maplinkcodechallenge.domain.Location;
import br.com.hrom.maplinkcodechallenge.domain.Villain;

/**
 * Resposta do BatComputador contendo os dados de probabilidade de ataque de um vilão a determinados alvos
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class VillainAttackProbability {
	
	private Villain villain;
	private List<Location> targets;	
	
	public Villain getVillain() {
		return villain;
	}
	public void setVillain(Villain villain) {
		this.villain = villain;
	}
	
	public void addTarget(Location target){
		targets.add(target);
	}
	
	public List<Location> getTargets() {
		return targets;
	}
	public void setTargets(List<Location> targets) {
		this.targets = targets;
	}
	
}
