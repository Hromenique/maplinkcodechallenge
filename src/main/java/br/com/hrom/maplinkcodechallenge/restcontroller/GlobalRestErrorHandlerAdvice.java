package br.com.hrom.maplinkcodechallenge.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.hrom.maplinkcodechallenge.dto.ErrorMessageResponse;

/**
 * Trata os erros que não foram capturados ocorridos nos controllers que representam as apis rest
 * 
 * @author Hromenique Cezniowscki Leite Batista
 *
 */
@ControllerAdvice(basePackageClasses=VillainProbabilityAttackRestController.class)
public class GlobalRestErrorHandlerAdvice {

	private final Logger logger = LoggerFactory.getLogger(GlobalRestErrorHandlerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessageResponse> handleAnyUncaughtException(Exception e){
		logger.error("Unexpected error", e);
		
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessageResponse("Unexpected error"));
	}
}
