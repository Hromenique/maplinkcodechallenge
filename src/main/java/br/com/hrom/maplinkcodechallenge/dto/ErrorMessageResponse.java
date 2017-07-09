package br.com.hrom.maplinkcodechallenge.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizado como o resposta para os casos onde ocorre um em uma api REST
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
public class ErrorMessageResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<ErrorMessage> errors = new ArrayList<>();

	public ErrorMessageResponse() {

	}

	public ErrorMessageResponse(String message) {
		errors.add(new ErrorMessage(message));
	}

	public ErrorMessageResponse(List<ErrorMessage> errors) {
		super();
		this.errors = errors;
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorMessage> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ErrorMessageResponse [errors=" + errors + "]";
	}

}
