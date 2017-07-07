package br.com.hrom.maplinkcodechallenge.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.hrom.maplinkcodechallenge.domain.City;
import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.domain.Location;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;
import br.com.hrom.maplinkcodechallenge.exception.OutOfCityException;

@Service
public class VillainAttackProbabilityServiceImpl implements VillainAttackProbabilityService{

	@Autowired
	private City gotham;
	
	@Value("${villain.actionRadiusInKm}")
	private double actionRadius;

	@Override
	public VillainAttackProbability calculteProbabilityAttack(Point villainPoint) {
		if(!gotham.contains(villainPoint))
			throw new OutOfCityException("Joker is out of City. Another hero can capture him!");
		
		List<Location> jokersTargets = gotham.getTargets()
				.stream().filter(target -> target.getLocation().calculeDistanceTo(villainPoint) <= actionRadius)
				.collect(Collectors.toList());
		
		int numberOfTargets = jokersTargets.size();
		
		
		return null;
	}
	
	public void xpto(List<Location> targets){
		
	}
}
