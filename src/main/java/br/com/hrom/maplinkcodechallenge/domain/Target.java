package br.com.hrom.maplinkcodechallenge.domain;

/**
 * Um local que é um possível alvo de ação de um vilão
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Target extends Location {
	private static final long serialVersionUID = 1L;

	private double distanceToVillain;
	private double probability;

	public Target(String place, Point location) {
		super(place, location);
	}	
	
	public Target(String place, Point location, double distanceToVillain, double probability) {
		super(place, location);
		this.distanceToVillain = distanceToVillain;
		this.probability = probability;
	}

	/**
	 * Calcula e atribui a distância até o vilão
	 * 
	 * @param villainPoint {@link Point} onde se encontra o vilão
	 */
	public void setDistanceToVillain(Point villainPoint){
		this.distanceToVillain = this.getLocation().calculeDistanceTo(villainPoint);
	}

	public double getDistanceToVillain() {
		return distanceToVillain;
	}

	public void setDistanceToVillain(double distanceToVillain) {
		this.distanceToVillain = distanceToVillain;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

}
