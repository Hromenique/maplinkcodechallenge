package br.com.hrom.maplinkcodechallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Uma localidade que pode ser um um possível alvo de ação de vilão
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Target extends Location {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private double distanceToVillain;
	private double probability;

	public Target(Location location){
		super(location.getName(), location.getPoint());
	}
	
	/**
	 * 
	 * @param location localidade cujo os dados alimentarão o {@link Target}
	 * @param villainPoint utilizado para calcular a distância do vilão até o alvo
	 */
	public Target(Location location, Point villainPoint){
		this(location);
		double distance = getPoint().calculeDistanceTo(villainPoint);
		setDistanceToVillain(distance);
	}
	
	public Target(String place, Point location) {
		super(place, location);
	}	
	
	public Target(String place, Point location, double distanceToVillain, double probability) {
		super(place, location);
		this.distanceToVillain = distanceToVillain;
		this.probability = probability;
	}
	
	@JsonProperty("place")
	@Override
	public String getName() {
		return super.getName();
	}
	
	@JsonProperty("location")
	@Override
	public Point getPoint() {
		return super.getPoint();
	}

	/**
	 * Calcula e atribui a distância até o vilão
	 * 
	 * @param villainPoint {@link Point} onde se encontra o vilão
	 */
	public void setDistanceToVillain(Point villainPoint){
		this.distanceToVillain = getPoint().calculeDistanceTo(villainPoint);
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
