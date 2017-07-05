package br.com.hrom.maplinkcodechallenge.domain;

import static org.springframework.util.Assert.notNull;

/**
 * Um possível alvo de um vilão do Batman
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Target {

	private String place;
	private Point location;
	private double probability;

	public Target(String place, Point location) {
		super();
		setPlace(place);
		setLocation(location);		
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		notNull(location, "location não pode ser null");
		this.location = location;
	}	

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public String toString() {
		return "Target [place=" + place + ", location=" + location + ", probability=" + probability + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		long temp;
		temp = Double.doubleToLongBits(probability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Target other = (Target) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (Double.doubleToLongBits(probability) != Double.doubleToLongBits(other.probability))
			return false;
		return true;
	}

}
