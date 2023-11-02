package com.Exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {

//	@ExceptionHandler(ServletRequestBindingException.class)
//	public ResponseEntity<Object>handleHeaderError(Exception exception,WebRequest request){
//		List<String>details=new ArrayList<String>();
//		details.add(exception.getLocalizedMessage());
//		ErrorResponse res=new ErrorResponse("OOPs...Header Missing",details);
//		return new ResponseEntity(res,HttpStatus.BAD_REQUEST);
//	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object>handleAllErrors(Exception exception,WebRequest request){
		List<String>details=new ArrayList<String>();
		details.add(exception.getLocalizedMessage());
		ErrorResponse res=new ErrorResponse("Something went wrong",details);
		return new ResponseEntity(res,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
