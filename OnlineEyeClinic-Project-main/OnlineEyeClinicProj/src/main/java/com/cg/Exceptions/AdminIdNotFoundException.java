package com.cg.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AdminIdNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public AdminIdNotFoundException(String message)
	{
		super(message);
	}

}
