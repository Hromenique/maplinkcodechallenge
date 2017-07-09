package br.com.hrom.maplinkcodechallenge.math.geo;

import java.io.IOException;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

public class Teste {
	public static void main(String[] args) throws ApiException, InterruptedException, IOException{
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyA4WqZ0dp1eqfKumcHfeEPXZIOpoYacNNY");
		GeocodingResult[] results =  GeocodingApi.geocode(context,
		    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		System.out.println(results[0].formattedAddress);
		System.out.println(results);
		
		
	}
}
