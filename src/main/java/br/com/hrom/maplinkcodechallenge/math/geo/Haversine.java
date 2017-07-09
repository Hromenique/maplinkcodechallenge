package br.com.hrom.maplinkcodechallenge.math.geo;

import org.springframework.util.Assert;

import br.com.hrom.maplinkcodechallenge.domain.Point;

/**
 * Representa a <a href="https://rosettacode.org/wiki/Haversine_formula">Fórmula de Haversine</a>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class Haversine {
	
	//Raio da Terra em quilometros
	private static final  double R = 6371;

	/**
	 * 
	 * @param r raio da terra em quilometros
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double calculeteDistance(double r, double lat1, double lng1, double lat2, double lng2){
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lng2 - lng1);
		
		lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a)); 
		
        return r * c;
	}
	
	public static double calculeteDistance(double lat1, double lng1, double lat2, double lng2){
		return calculeteDistance(R, lat1, lng1, lat2, lng2);
	}
	
	/**
	 * 
	 * @param r raio da terra em quilometros
	 * @param a
	 * @param b
	 * @return
	 */
	public static double calculeteDistance(double r, Point a, Point b){
		Assert.notNull(a, "Point a não pode ser null");
		Assert.notNull(b, "Point b não pode ser null");
		
		double lat1 = a.getLat();
		double lat2 = b.getLat();
		double lng1 = a.getLng();
		double lng2 = b.getLng();
		
		return calculeteDistance(r, lat1, lng1, lat2, lng2);
	}
	
	public static double calculeteDistance(Point a, Point b){
		return calculeteDistance(R, a, b);
	}
}
