package br.com.hrom.maplinkcodechallenge.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.service.geocoding.GeoCodingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoCodingServiceTest {
	
	@Autowired
	private GeoCodingService service;
	
	@Ignore
	@Test
	public void buscaPontoApartirDoEndereco(){
		String address = "Av. José Rodrigues Píres, 537 - Jundiapeba, Mogi das Cruzes - SP"; // -23.5468679,-46.2645081
		Optional<Point> point = service.fromAddressToPoint(address);
		assertTrue(point.isPresent());
		assertThat(point.get(), 
				allOf(
						hasProperty("lat", equalTo(-23.5468679)), 
						hasProperty("lng", equalTo(-46.2645081))
						)
				); 
	}
	
	@Ignore
	@Test
	public void buscaPontoDeEnderecoNaoExistente(){
		String address = "Av. dhsjdjadhjsdfhfdajhhj, 45 - sddsfdfd, dsdsf - SP"; 
		Optional<Point> point = service.fromAddressToPoint(address);
		
		assertFalse(point.isPresent());
	}
	
	@Ignore
	@Test
	public void buscaPontoPorLocalizacao(){
		String locationName = "Mogi Shopping"; //-23.5160314, -46.1797656
		Optional<Point> point = service.fromLocationToPoint(locationName);
		
		assertTrue(point.isPresent());
		assertThat(point.get(), 
					allOf(
							hasProperty("lat", equalTo(-23.5160314)), 
							hasProperty("lng", equalTo(-46.1797656))
							)
				); 
	}
	
	@Ignore
	@Test
	public void buscaPontoPorLocalizacaoNaoExistente(){
		String locationName = "hdkfsahfsadkjdsfhjk"; //-23.5160314,-46.1819543
		Optional<Point> point = service.fromLocationToPoint(locationName);
		
		assertFalse(point.isPresent());
	}
	
	@Ignore
	@Test
	public void buscaPontoPorLocalizacaoDentroDeGothamCity(){
		String locationName = "Wayne Enterprises";
		Optional<Point> point = service.fromLocationToPoint(locationName);
		
		assertTrue(point.isPresent());
		assertThat(point.get(), 
					allOf(
							hasProperty("lat", equalTo(40.759134)), 
							hasProperty("lng", equalTo(-73.979021))
							)
				); 
	}
	

}
