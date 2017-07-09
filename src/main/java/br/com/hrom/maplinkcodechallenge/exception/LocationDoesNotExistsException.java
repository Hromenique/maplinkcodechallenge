package br.com.hrom.maplinkcodechallenge.exception;

public class LocationDoesNotExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LocationDoesNotExistsException() {
		super();
	}

	public LocationDoesNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public LocationDoesNotExistsException(String message) {
		super(message);
	}

	public LocationDoesNotExistsException(Throwable cause) {
		super(cause);
	}

}
