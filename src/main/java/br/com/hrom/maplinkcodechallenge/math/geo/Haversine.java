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
	
	//Raio da Terra em Kilometros
	private  double R = 6371;
	
	private Haversine(){
		
	}
	
	private Haversine(double r){
		this.R = r;
	}
	
	/**
	 * 
	 * @return uma nova instância de Haversine cujo valor do raio da terra utilizado nos calculos é 6371.0 km
	 */
	public static Haversine instance(){
		return new Haversine();
	}
	
	/**
	 * 
	 * @param r distância do raio da terra em quiilomêtros (km) utilizados nos cálculos
	 * @return uma nova instância de Haversine cujo valor do raio da terra utilizado nos cálculos é definido pelo parâmetro
	 */
	public static Haversine instance(double r){
		return new Haversine(r);
	}

	public double calculeDistance(double lat1, double lng1, double lat2, double lng2){
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lng2 - lng1);
		
		lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a)); 
		
        return R * c;
	}
	
	public double calculeDistance(Point a, Point b){
		Assert.notNull(a, "Point a não pode ser null");
		Assert.notNull(b, "Point b não pode ser null");
		
		double lat1 = a.getLat();
		double lat2 = b.getLat();
		double lng1 = a.getLng();
		double lng2 = b.getLng();
		
		return calculeDistance(lat1, lng1, lat2, lng2);
	}
}
