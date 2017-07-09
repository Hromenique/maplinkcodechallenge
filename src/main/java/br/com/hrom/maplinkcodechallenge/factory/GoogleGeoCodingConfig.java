package br.com.hrom.maplinkcodechallenge.factory;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.maps.GeoApiContext;

/**
 * Factory (Configurações) para o consumo da api do GoogleMaps via <a href="https://github.com/googlemaps/google-maps-services-java">client Java</a>
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
@Configuration
public class GoogleGeoCodingConfig {

	
	@Bean
	public GeoApiContext xpto(@Value("${googlemaps.apikey}") String apiKey, @Value("googlemaps.timeoutInMili")long timeoutInMili){
		return new GeoApiContext()
				.setApiKey(apiKey)
				.setConnectTimeout(timeoutInMili, TimeUnit.MILLISECONDS);
	}
}
