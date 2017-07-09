package br.com.hrom.maplinkcodechallenge.exception;

import br.com.hrom.maplinkcodechallenge.domain.Point;

/**
 * Lançada quando por algum motivo não é encontrado um {@link Point}
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class PointNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PointNotFoundException() {
		super();
	}

	public PointNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PointNotFoundException(String message) {
		super(message);
	}

	public PointNotFoundException(Throwable cause) {
		super(cause);
	}

}
