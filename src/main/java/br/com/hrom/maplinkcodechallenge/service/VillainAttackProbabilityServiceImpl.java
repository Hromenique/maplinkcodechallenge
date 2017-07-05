package br.com.hrom.maplinkcodechallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.hrom.maplinkcodechallenge.domain.City;
import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;

@Service
public class VillainAttackProbabilityServiceImpl implements VillainAttackProbabilityService{

	@Autowired
	private City gotham;
	
	@Value("${villain.actionRadiusInKm}")
	private double actionRadius;

	@Override
	public VillainAttackProbability calculteProbabilityAttack(Point villainPoint) {
		
		
		
		return null;
	}
}
