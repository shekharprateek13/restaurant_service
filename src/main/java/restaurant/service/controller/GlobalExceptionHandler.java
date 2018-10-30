package restaurant.service.controller;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import restaurant.service.exception.ApiException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	@ExceptionHandler(value = {NoSuchElementException.class,HttpClientErrorException.class, NullPointerException.class})
	protected ResponseEntity<Object> handleConflicts(RuntimeException ex, WebRequest request) {
		logger.error("No Records Found for Request URL: "+ request);
		ApiException exception = new ApiException();
		exception.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		exception.setHttpStatus(HttpStatus.NOT_FOUND);
		exception.setMessage("No Records found.");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex,exception,httpHeaders, HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class })
	protected ResponseEntity<Object> handleInvalidArguments(RuntimeException ex, WebRequest request) {
		ServletWebRequest servletWebRequest = (ServletWebRequest)request;
		String requestURI = servletWebRequest.getRequest().getRequestURI();
		logger.error("Invalid Parameters for Request URL: "+ requestURI);
		ApiException exception = new ApiException();
		exception.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		exception.setHttpStatus(HttpStatus.BAD_REQUEST);
		exception.setMessage("Input argument [id] should be Integer.");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex,exception,httpHeaders, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { NumberFormatException.class, IllegalArgumentException.class })
	protected ResponseEntity<Object> handleInvalidArgumentsForMultipleIds(RuntimeException ex, WebRequest request) {
		ServletWebRequest servletWebRequest = (ServletWebRequest)request;
		String requestURI = servletWebRequest.getRequest().getRequestURI();
		logger.error("Invalid Parameters for Request URL: "+ requestURI);
		ApiException exception = new ApiException();
		exception.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
		exception.setHttpStatus(HttpStatus.BAD_REQUEST);
		exception.setMessage("Input argument comma separated list of Integers. For example: 156835,156895,151810");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex,exception,httpHeaders, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { RestClientException.class })
	protected ResponseEntity<Object> handleInvalidURL(RuntimeException ex, WebRequest request) {
		logger.error("Unable to fetch data from External API for Request URL"+ request);
		ApiException exception = new ApiException();
		exception.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exception.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		exception.setMessage("Unable to fetch data from External API. Please try again after sometime");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex,exception,httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleOtherExceptions(RuntimeException ex, WebRequest request) {
		logger.error("Application is down for Request URL"+ request);
		ApiException exception = new ApiException();
		exception.setHttpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		exception.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		exception.setMessage("Application is down. Please try again after sometime.");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex,exception,httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}