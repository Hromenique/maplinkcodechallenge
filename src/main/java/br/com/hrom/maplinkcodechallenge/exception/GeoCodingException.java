package br.com.hrom.maplinkcodechallenge.exception;

/**
 * Um erro/exceção genérica que pode ocorre durante uma integração com a api de GeoCoding
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class GeoCodingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GeoCodingException() {
		super();
	}

	public GeoCodingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GeoCodingException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeoCodingException(String message) {
		super(message);
	}

	public GeoCodingException(Throwable cause) {
		super(cause);
	}

}
