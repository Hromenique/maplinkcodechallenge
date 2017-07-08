package br.com.hrom.maplinkcodechallenge.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hrom.maplinkcodechallenge.domain.City;
import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.domain.Location;

/**
 * Factory de {@link City}
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */

@Configuration
public class CityFactory {

	/**
	 * 
	 * @return uma {@link City} contendo os dados de <a href="https://pt.wikipedia.org/wiki/Gotham_City">Gotham City</a>
	 */
	@Bean
	public City gothamCity() {
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("Amusement Mile", new Point(40.748288, -73.985791)));
		locations.add(new Location("Gotham University", new Point(40.753722, -73.977494)));
		locations.add(new Location("Giordano Botanical Gardens", new Point(40.753875, -73.983745)));
		locations.add(new Location("Gotham Arms Apartment", new Point(40.761687, -73.981873)));
		locations.add(new Location("Old Gotham Subway", new Point(40.759941, -73.975449)));
		locations.add(new Location("Special Crimes Unit", new Point(40.749428, -73.976931)));
		locations.add(new Location("GCPD Headquarters", new Point(40.753645, -73.988117)));
		locations.add(new Location("Gotham City Hall", new Point(40.753170, -73.981972)));
		locations.add(new Location("The Clocktower", new Point(40.755469, -73.976731)));
		locations.add(new Location("Wayne Enterprises", new Point(40.759134, -73.979021)));
		
		Point bottomLeftPoint = new Point( 40.746422, -73.994753);
		Point topRightPoint = new Point(40.763328, -73.968039);
		
		return new City("Gotham City", locations, bottomLeftPoint, topRightPoint);
	}

}
