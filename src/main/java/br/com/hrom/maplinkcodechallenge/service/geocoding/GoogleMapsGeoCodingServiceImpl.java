package br.com.hrom.maplinkcodechallenge.service.geocoding;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import br.com.hrom.maplinkcodechallenge.domain.City;
import br.com.hrom.maplinkcodechallenge.domain.Location;
import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.exception.GeoCodingException;

/**
 * Serviço para tratar dados de geolocalização (latitude e longitude)
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
@Service
public class GoogleMapsGeoCodingServiceImpl implements GeoCodingService {
	
	@Autowired
	private GeoApiContext geoContext;
	
	@Autowired
	private City gotham;
	
	/**
	 * Obtém um {@link Point} de um endereço (ou localização que não esteja dentro de Gotham)
	 * 
	 * @param address endereço
	 * @return as coordenadas geográficas do endereço
	 * @throws GeoCodingException lançado quando ocorre algum tipo de erro genérico no consumo do serviço
	 */
	@Override
	public Optional<Point> fromAddressToPoint(String address) throws GeoCodingException {
		try {
			GeocodingResult[] results = GeocodingApi.geocode(geoContext, address).await();

			if (results.length == 0)
				return Optional.empty();

			LatLng location = results[0].geometry.location;
			return Optional.of(new Point(location.lat, location.lng));
			
		} catch (ApiException | InterruptedException | IOException e) {
			throw new GeoCodingException(e);
		}
	}
	
	/**
	 * Obtém um {@link Point} de um local, sendo este pertecente a cidade de Gotham ou não
	 * 
	 * @param locationName nome do local
	 * @return as coordenadas geográficas do local
	 * @throws GeoCodingException lançado quando ocorre algum tipo de erro genérico no consumo do serviço
	 */
	@Override
	public Optional<Point> fromLocationToPoint(String locationName) throws GeoCodingException {
		Optional<Location> location = gotham.findLocationByName(locationName);
		if (location.isPresent()) {
			return Optional.of(location.get().getPoint());
		}
		return fromAddressToPoint(locationName);

	}

}
