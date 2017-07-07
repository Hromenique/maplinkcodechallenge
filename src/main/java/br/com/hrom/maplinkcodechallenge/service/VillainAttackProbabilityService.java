package br.com.hrom.maplinkcodechallenge.service;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;
import br.com.hrom.maplinkcodechallenge.exception.OutOfCityException;

/**
 * Serviço que trata a probabilidade de ataque de um vilão
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public interface VillainAttackProbabilityService {
	
	/**
	 * Calcula a probabilidade de ataque de um vilão
	 *  
	 * @throws OutOfCityException lançado quando o ponto encontra-se fora do perímetro da cidade
	 */
	VillainAttackProbability calculteProbabilityAttack(Point villainPoint) throws OutOfCityException;

}
