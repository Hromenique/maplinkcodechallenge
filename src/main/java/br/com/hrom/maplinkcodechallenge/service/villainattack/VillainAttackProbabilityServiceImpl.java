package br.com.hrom.maplinkcodechallenge.service.villainattack;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.hrom.maplinkcodechallenge.domain.City;
import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.domain.Target;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;
import br.com.hrom.maplinkcodechallenge.exception.OutOfCityException;
import br.com.hrom.maplinkcodechallenge.factory.VillainFactory;

@Service
public class VillainAttackProbabilityServiceImpl implements VillainAttackProbabilityService{

	@Autowired
	private City gotham;
	
	@Autowired
	private VillainAttackProbabilityLogic villainAttackProbabilityLogic;
	
	@Value("${villain.actionRadiusInKm}")
	private double villainActionRadius;

	@Override
	public VillainAttackProbability calculteProbabilityAttack(Point villainPoint) {
		if(!gotham.contains(villainPoint))
			throw new OutOfCityException("Joker is out of City. Another hero can capture him!");
		
		List<Target> targets = gotham.getLocations().stream()
				.filter(location -> location.getPoint().calculeDistanceTo(villainPoint) <= villainActionRadius)
				.map(location -> new Target(location, villainPoint))
				.collect(Collectors.toList());		
		
		targets = villainAttackProbabilityLogic.calculeProbability(targets);
		
		return new VillainAttackProbability(VillainFactory.joker(villainPoint), targets);
	}

}
