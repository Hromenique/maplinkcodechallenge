package br.com.hrom.maplinkcodechallenge.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hrom.maplinkcodechallenge.dto.ErrorMessageResponse;
import br.com.hrom.maplinkcodechallenge.dto.VillainAttackProbability;
import br.com.hrom.maplinkcodechallenge.exception.OutOfCityException;
import br.com.hrom.maplinkcodechallenge.exception.PointNotFoundException;
import br.com.hrom.maplinkcodechallenge.service.villainattack.VillainAttackProbabilityService;

@RestController
@RequestMapping("/")
public class VillainProbabilityAttackRestController {	
	
	private static final String REGEX_LAT_LONG = "-?\\d+(\\.\\d+)?\\,-?\\d+(\\.\\d+)?";

	@Autowired
	private VillainAttackProbabilityService villainProbabilityService;
	
	@GetMapping(value="coordinate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> calculateByLatLong(@RequestParam("q") String latLong){	
		
		if(!latLong.matches(REGEX_LAT_LONG))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageResponse("Malformed latitude and longitude. The value must be <latitude>,<longitude>"));
	
		String[] latLongValues = latLong.split(",");
		Double latitude = new Double(latLongValues[0]);
		Double longitude = new Double(latLongValues[1]);
		
		if(!isValid(latitude, longitude))
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageResponse("Error in range of latitude/longitude. Latitude is beetwen -90 and 90. Longitude is beetwen -180 and 180"));		
		
		VillainAttackProbability response = villainProbabilityService.calculateProbabilityAttackByPoint(latitude, longitude);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="location", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<VillainAttackProbability> calculateByLocation(@RequestParam("q") String location){
		VillainAttackProbability response = villainProbabilityService.calculateProbabilityAttackByLocation(location);		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="address", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<VillainAttackProbability> calculateByAddress(@RequestParam("q") String address){
		VillainAttackProbability response = villainProbabilityService.calculateProbabilityAttackByAddress(address);
		return ResponseEntity.ok(response);
	}	
	
	@ExceptionHandler(OutOfCityException.class)
	private ResponseEntity<ErrorMessageResponse> handleOutOfCityException(OutOfCityException e){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorMessageResponse(e.getMessage()));
	}
	
	@ExceptionHandler(PointNotFoundException.class)
	private ResponseEntity<ErrorMessageResponse> handlePointNotFoundException(PointNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageResponse(e.getMessage()));
	}
	
	private boolean isValid(double latitude, double longitude){
		if((latitude >= -90.0 && latitude <= 90.0) && (longitude >= -180.0 && longitude <= 180.0))
			return true;
		
		return false;
	}

}
