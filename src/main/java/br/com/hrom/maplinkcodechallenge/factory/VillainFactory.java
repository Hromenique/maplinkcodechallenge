package br.com.hrom.maplinkcodechallenge.factory;

import br.com.hrom.maplinkcodechallenge.domain.Point;
import br.com.hrom.maplinkcodechallenge.domain.Villain;

/**
 * Fabrica de {@link Villain}
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class VillainFactory {

	Villain joker(){
		return new Villain("Joker");
	}
	
	Villain joker(Point location){
		Villain joker = joker();
		joker.setLocation(location);
		
		return joker;
	}
}
