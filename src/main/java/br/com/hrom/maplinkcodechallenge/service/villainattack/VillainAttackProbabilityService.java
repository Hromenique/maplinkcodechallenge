package br.com.hrom.maplinkcodechallenge.service.villainattack;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;
import br.com.hrom.maplinkcodechallenge.exception.PointNotFoundException;
import br.com.hrom.maplinkcodechallenge.exception.OutOfCityException;

/**
 * Serviço que trata a probabilidade de ataque de um vilão
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public interface VillainAttackProbabilityService {	

	/**
	 * Calcula a probabilidade de um atque de vilão
	 * 
	 * @param villainPoint Ponto onde se encontra o vilão
	 * @return dados indicando a probabilidade de ataque de um vilão
	 * @throws OutOfCityException quando o ponto encontra-se fora dos limites da cidade
	 */
	VillainAttackProbability calculateProbabilityAttackByPoint(Point villainPoint) throws OutOfCityException;

	/**
	 * Calcula a probabilidade de um atque de vilão
	 * 
	 * @param latitude
	 * @param longitude
	 * @return dados indicando a probabilidade de ataque de um vilão
	 * @throws OutOfCityException  quando o ponto encontra-se fora dos limites da cidade
	 */
	VillainAttackProbability calculateProbabilityAttackByPoint(double latitude, double longitude) throws OutOfCityException;
	
	/**
	 * Calcula a probabilidade de um atque de vilão
	 * 
	 * @param address endereço onde se encontra o vilão
	 * @return dados indicando a probabilidade de ataque de um vilão
	 * @throws OutOfCityException  quando o ponto encontra-se fora dos limites da cidade
	 * @throws PointNotFoundException quando o ponto onde se encontra o vilão não pode ser encontrado
	 */
	VillainAttackProbability calculateProbabilityAttackByAddress(String address) throws OutOfCityException, PointNotFoundException;
	
	/**
	 * Calcula a probabilidade de um atque de vilão
	 * 
	 * @param location localidade onde se encontra o vilão
	 * @return dados indicando a probabilidade de ataque de um vilão
	 * @throws OutOfCityException  quando o ponto encontra-se fora dos limites da cidade
	 * @throws PointNotFoundException quando o ponto onde se encontra o vilão não pode ser encontrado
	 */
	VillainAttackProbability calculateProbabilityAttackByLocation(String location) throws OutOfCityException, PointNotFoundException;

}
