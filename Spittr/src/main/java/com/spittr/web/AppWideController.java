package com.spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spittr.web.exceptions.DuplicateSpittleException;

/**
 * This declares an advice controller for every controller defined in the application
 * Methods defined over here are applied globally across all controller
 * @author deysi
 *
 */
@ControllerAdvice
public class AppWideController {
	@ExceptionHandler(DuplicateSpittleException.class)
	public String duplicateSpittleHandler()	{
		return "error/duplicate";
	}
	
	
	
}
