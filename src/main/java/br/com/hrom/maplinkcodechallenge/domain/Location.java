package br.com.hrom.maplinkcodechallenge.domain;

import static org.springframework.util.Assert.notNull;

import java.io.Serializable;

/**
 * Um localidade da cidade ({@link City})
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Point point;

	public Location(String place, Point location) {
		super();
		setName(place);
		setPoint(location);
	}

	public String getName() {
		return name;
	}

	public void setName(String place) {
		this.name = place;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point location) {
		notNull(location, "point não pode ser null");
		this.point = location;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", point=" + point + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

}
