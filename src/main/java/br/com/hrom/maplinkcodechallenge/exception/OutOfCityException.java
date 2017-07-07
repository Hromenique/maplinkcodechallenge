package br.com.hrom.maplinkcodechallenge.exception;

/**
 * Indica que um ponto encontra-se fora da cidade
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class OutOfCityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OutOfCityException() {
		super("Villain out of city, another hero can capture him");		
	}

	public OutOfCityException(String message) {
		super(message);
	}
	
	

}
