package com.ng.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CentralExceptionHandler {

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExceptionHandler(Exception e, Model m) {

		m.addAttribute("error", "Null Exception Occured");
		e.printStackTrace();

		return "Error";

	}

	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e) {

		e.printStackTrace();

		return "Error";

	}

}
