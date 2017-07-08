package br.com.hrom.maplinkcodechallenge.domain;

import java.io.Serializable;

/**
 * Uma determinada um ponto definido pelo par Latitude e longitude
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Point implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double lat;
	private double lng;

	public Point(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	/**
	 * Calcula a distância até outro ponto ({@link Point}). O calculo
	 * será feito utilizando a
	 * <a href="https://rosettacode.org/wiki/Haversine_formula">fórmula de
	 * Haversine</a>
	 * 
	 * @param other a distância será calculada até este ponto
	 *            
	 * @return a distância entre os dois pontos utilizando a <b>Fórmula de Haversine</b>
	 */
	public double calculeDistanceTo(Point other) {
		return 0;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Location [lat=" + lat + ", lng=" + lng + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		return true;
	}

}
