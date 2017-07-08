package br.com.hrom.maplinkcodechallenge.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CityTest {
	
	private City city;	
	
	@SuppressWarnings("unchecked")
	@Test
	public void getLocation(){
		city = createNewCity();
		List<Location> locations = createLocations();
		city.setLocations(locations);
		
		assertEquals(2, city.getLocations().size());
		assertThat(city.getLocations(),
				contains(
						hasProperty("name", equalTo("Amusement Mile")), 
						hasProperty("name", equalTo("Gotham University")))
				);
		
		assertNotSame(locations.get(0), city.getLocations().get(0));
		assertNotSame(locations.get(1), city.getLocations().get(1));
		
		assertEquals(locations.get(0), city.getLocations().get(0));
		assertEquals(locations.get(1), city.getLocations().get(1));
		
	}
	
	@Test
	public void contemPonto(){
		City city = createNewCity();
		assertTrue(city.contains(new Point(40.756422,  -73.978039)));
	}
	
	@Test
	public void naoContemPonto(){
		City city = createNewCity();
		assertFalse(city.contains(new Point(40.736422,  -73.978039)));
	}
	
	private City createNewCity(){
		List<Location> locations = createLocations();
		
		Point bottomLeftPoint = new Point( 40.746422, -73.994753);
		Point topRightPoint = new Point(40.763328, -73.968039);
		
		return new City("Gotham City", locations, bottomLeftPoint, topRightPoint);
	}

	private List<Location> createLocations() {
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("Amusement Mile", new Point(40.748288, -73.985791)));
		locations.add(new Location("Gotham University", new Point(40.753722, -73.977494)));
		return locations;
	}
	
	

}
