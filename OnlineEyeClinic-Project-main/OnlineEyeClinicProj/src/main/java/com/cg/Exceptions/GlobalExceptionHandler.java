package com.cg.Exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandler 
{
	
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), "Validation Failed",ex.getBindingResult().toString());
		  return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
		}
	
	    @ExceptionHandler(PatientIdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> patientIdNotFoundException(PatientIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(AppointmentIdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> appointmentIdNotFoundException(AppointmentIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(ReportIdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> reportIdNotFoundException(ReportIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(TestIdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> testIdNotFoundException(TestIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(DoctorIdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> doctorIdNotFoundException(DoctorIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(SpectacleIdNotFoundException.class)
	    public ResponseEntity<ErrorDetails> spectacleIdNotFoundException(SpectacleIdNotFoundException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    @ExceptionHandler(UserNameAlreadyExistException.class)
	    public ResponseEntity<ErrorDetails> userNameAlreadyExistException(UserNameAlreadyExistException ex, WebRequest request) {
	         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	    
	    
	    @ExceptionHandler(Exception.class) 
		  public ResponseEntity<ErrorDetails> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
		  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
		  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); }

}
