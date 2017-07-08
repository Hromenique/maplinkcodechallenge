package br.com.hrom.maplinkcodechallenge.math.geo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.math.geo.Haversine;

public class HaversineTest {
	
	@Test
	public void calculaDistanciaUtilizandoLatitudeELongitude(){
		
		double lat1 = 47.6788206;
		double lng1 = -122.3271205;
		
		double lat2 = 47.6788206;
		double lng2 = -122.5271205;
		
		double distance = Haversine.instance().calculeDistance(lat1, lng1, lat2, lng2);
		
		assertEquals(14.973190481586224, distance, 0);		
	}
	
	@Test
	public void calculaDistanciaUsandoPontos(){
		Point a = new Point(47.6788206, -122.3271205);
		Point b = new Point(47.6788206, -122.5271205);
		
		double distance = Haversine.instance().calculeDistance(a, b);
		
		assertEquals(14.973190481586224, distance, 0);
	}
	
	@Test
	public void calculaDistanciaDePontosIguais(){
		double lat = 47.6788206;
		double lng = -122.3271205;
		double distance = Haversine.instance().calculeDistance(lat, lng, lat, lng);
		assertEquals(0, distance, 0);	
		
		Point a = new Point(lat, lng);
		Point b = new Point(lat, lng);
		distance = Haversine.instance().calculeDistance(a, b);
		assertEquals(0, distance, 0);	
	}
	
	@Test
	public void calculaDistanciaComRaioDiferentede6371Km(){
		double novoRaio = 6373;
		
		double lat1 = 38.898556;
		double lng1 = -77.037852;
		
		double lat2 = 38.897147;
		double lng2 = -77.043934;
		
		Haversine haversine = Haversine.instance(novoRaio);
		
		double distance = haversine.calculeDistance(lat1, lng1, lat2, lng2);
		assertEquals(0.5493281835413389, distance, 0);
		
		Point a = new Point(lat1, lng1);
		Point b = new Point(lat2, lng2);
		distance = haversine.calculeDistance(a, b);
		assertEquals(0.5493281835413389, distance, 0);		
	}

}
