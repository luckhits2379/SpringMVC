package com.ng.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ng.spring.mvc.model.Student;

@Controller
public class ComplexFormController {

	@RequestMapping(path = "/complexForm")
	public String complexForm() {

		return "complexForm";

	}

	@RequestMapping(value = "/processComplexForm")
	public String processForm(@ModelAttribute Student student) {

		System.out.println(student);

		return "complexForm_success";

	}

}
