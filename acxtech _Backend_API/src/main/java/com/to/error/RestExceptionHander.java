package com.to.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.SignatureException;



@RestControllerAdvice
public class RestExceptionHander
     
{
	
	//invalid user name and password exception	handler
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidUserNamePasswordException.class)
	public Map<String, String> InvalidUserNameAndPasswrodException(InvalidUserNamePasswordException ex){
		Map<String, String> map=new HashMap<>();
		map.put("errorMessage", ex.getMessage());
		return map;
	}
	
	//invalid jwt token handler
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(SignatureException.class)
	public String invalidJwtTokenEceptionHandler(SignatureException ex) {
		return ex.getMessage();
	}
	
	
	
	//user not found exception handler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> userNotFoundException(UserNotFoundException ex){
		Map<String, String> map=new HashMap<>();
		map.put("errorMessage", ex.getMessage());
		return map;
	}
	
	//method for handling the user id all ready taken
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(UserIdAllReadyExist.class)
	public Map<String, String> empNotFoundException(UserIdAllReadyExist ex){
		Map<String, String> map=new HashMap();
		map.put("errorMessage", ex.getMessage());
		return map;
	}	
	
	//user validation 
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(e->{
			map.put(e.getField(),e.getDefaultMessage());			
		});
		
		return map;
	}
	
	
}
