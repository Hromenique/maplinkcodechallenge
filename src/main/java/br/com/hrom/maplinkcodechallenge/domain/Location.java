package br.com.hrom.maplinkcodechallenge.domain;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;

/**
 * Um local na cidade ({@link City})
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	private String place;
	private Point location;

	public Location(String place, Point location) {
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

	@Override
	public String toString() {
		return "Location [place=" + place + ", location=" + location + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
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
		Location other = (Location) obj;
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
		return true;
	}

}
