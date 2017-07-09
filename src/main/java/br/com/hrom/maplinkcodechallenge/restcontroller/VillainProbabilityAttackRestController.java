package br.com.hrom.maplinkcodechallenge.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class VillainProbabilityAttackRestController {	
	
	//Pattern para latitude e longitude -?\d+(\.\d+)?\,-?\d+(\.\d+)?
	//Ex: 10,20; 10.5,20.66666; -10.5,50.9
	private static final String REGEX_LAT_LONG = "-?\\d+(\\.\\d+)?\\,-?\\d+(\\.\\d+)?";

	@GetMapping(value="coordinate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> calculateByLatLong(@RequestParam("q") String latLong){	
		
		if(!latLong.matches(REGEX_LAT_LONG)){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Malformed latitude and longitude. The value must be <latitude>,<longitude>");
		}	
		
		
		return ResponseEntity.ok(latLong);
	}
	
	@GetMapping(value="location", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> calculateByLocation(@RequestParam("q") String location){
		System.out.println("----------------------------");
		System.out.println("por location");
		System.out.println(location);
		
		return ResponseEntity.ok(location);
	}
	
	@GetMapping(value="address", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> calculateByAddress(@RequestParam("q") String address){
		System.out.println("----------------------------");
		System.out.println("por address");
		System.out.println(address);
		
		return ResponseEntity.ok(address);
	}

}
