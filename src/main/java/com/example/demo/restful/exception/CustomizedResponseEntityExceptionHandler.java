package com.example.demo.restful.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*
 * Specialization of @Component for classes that declare @ExceptionHandler, @InitBinder, 
 * or @ModelAttribute methods to be shared across multiple @Controller classes. 
 */
@ControllerAdvice
/*
 * Extends ResponseEntityExceptionHandler which handles Spring all MVC raised exceptions 
 * by returning a ResponseEntity
 */
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	/*
	 * This method will handle all the exceptions of type Exception.
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * This method will handle UserNotFoundException
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	/*
	 * This method will handle all the request having invalid method argument
	 * for which validation is enabled
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		StringBuilder message = new StringBuilder();
		int count = 0;
		for(FieldError fe: ex.getFieldErrors()) {
			message.append("Error ").append(++count).append(": ").append(fe.getDefaultMessage()).append(" ");
		}
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), message.toString(), request.getDescription(false));
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
