package br.com.hrom.maplinkcodechallenge.service.villainattack;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.hrom.maplinkcodechallenge.domain.City;
import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.domain.Target;
import br.com.hrom.maplinkcodechallenge.domain.comparator.TargetComparator;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;
import br.com.hrom.maplinkcodechallenge.exception.PointNotFoundException;
import br.com.hrom.maplinkcodechallenge.exception.OutOfCityException;
import br.com.hrom.maplinkcodechallenge.factory.VillainFactory;
import br.com.hrom.maplinkcodechallenge.service.geocoding.GeoCodingService;

/**
 * Serviço que trata a probabilidade de ataque de um vilão
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
@Service
public class VillainAttackProbabilityServiceImpl implements VillainAttackProbabilityService{

	@Autowired
	private City gotham;
	
	@Autowired
	private GeoCodingService geoCodingService;
	
	@Autowired
	private VillainAttackProbabilityLogic villainAttackProbabilityLogic;
	
	@Value("${villain.actionRadiusInKm}")
	private double villainActionRadius;

	@Override
	public VillainAttackProbability calculateProbabilityAttackByPoint(double latitude, double longitude) throws OutOfCityException{
		return calculateProbabilityAttackByPoint(new Point(latitude, longitude));
	}

	@Override
	public VillainAttackProbability calculateProbabilityAttackByPoint(Point villainPoint) throws OutOfCityException {
		if(!gotham.contains(villainPoint))
			throw new OutOfCityException("Joker is out of Gotham City. Another hero can capture him!");
		
		List<Target> targets = gotham.getLocations().stream()
				.filter(location -> location.getPoint().calculeDistanceTo(villainPoint) <= villainActionRadius)
				.map(location -> new Target(location, villainPoint))
				.collect(Collectors.toList());		
		
		targets = villainAttackProbabilityLogic.calculeProbability(targets);
		targets.sort(TargetComparator.BY_PROBABILITY_DESC);
		
		return new VillainAttackProbability(VillainFactory.joker(villainPoint), targets);
	}

	@Override
	public VillainAttackProbability calculateProbabilityAttackByAddress(String address) throws OutOfCityException, PointNotFoundException {
		Optional<Point> point = geoCodingService.fromAddressToPoint(address);
		
		if(!point.isPresent())
			throw new PointNotFoundException("Point(latitude/longitude) not found to address: " + address);
		
		return calculateProbabilityAttackByPoint(point.get());
	}

	@Override
	public VillainAttackProbability calculateProbabilityAttackByLocation(String locationName) throws OutOfCityException, PointNotFoundException {
		Optional<Point> point = geoCodingService.fromLocationToPoint(locationName);
		
		if(!point.isPresent())
			throw new PointNotFoundException("Point(latitude/longitude) not found to location: " + locationName);
		
		return calculateProbabilityAttackByPoint(point.get());
	}

}
