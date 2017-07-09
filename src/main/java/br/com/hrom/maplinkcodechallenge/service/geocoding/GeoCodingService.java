package br.com.hrom.maplinkcodechallenge.service.geocoding;

import java.util.Optional;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.exception.GeoCodingException;

public interface GeoCodingService {

	/**
	 * Obtém um {@link Point} de um endereço (ou localização que não esteja dentro de Gotham)
	 * 
	 * @param address endereço
	 * @return as coordenadas geográficas do endereço
	 * @throws GeoCodingException lançado quando ocorre algum tipo de erro genérico no consumo do serviço
	 */
	Optional<Point> fromAddressToPoint(String address) throws GeoCodingException;

	/**
	 * Obtém um {@link Point} de um local, sendo este pertecente a cidade de Gotham ou não
	 * 
	 * @param locationName nome do local
	 * @return as coordenadas geográficas do local
	 * @throws GeoCodingException lançado quando ocorre algum tipo de erro genérico no consumo do serviço
	 */
	Optional<Point> fromLocationToPoint(String locationName) throws GeoCodingException;

}