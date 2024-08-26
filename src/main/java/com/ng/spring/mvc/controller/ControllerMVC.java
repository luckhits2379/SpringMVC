package com.ng.spring.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ng.spring.mvc.model.User;
import com.ng.spring.mvc.orm.service.UserService;

@Controller
public class ControllerMVC {

	@Autowired
	UserService userService;

	@RequestMapping("/modelwithStaticContent")
	public String modelwithStaticContent(Model model) {

		System.out.println("Inside modelwithStaticContent");
		model.addAttribute("full name", "Nirmal Gurjar");
		model.addAttribute("roll number", 671522);

		return "model_with_static_content";
	}

	@RequestMapping("/modelandview")
	public ModelAndView about() {

		System.out.println("Inside about");
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("full name", new String[] { "Nirmal", "Singh", "Gurjar" });
		modelview.setViewName("ModelAndView");

		return modelview;
	}

	@RequestMapping("/jstl")
	public ModelAndView jstl() {

		System.out.println("Inside jstl");

		ModelAndView modelview = new ModelAndView();
		modelview.addObject("full_name", new String[] { "Nirmal", "Singh", "Gurjar" });
		modelview.addObject("roll_number", 671522);
		modelview.setViewName("jstl");

		return modelview;
	}

	@RequestMapping("/signupUsingParam")
	public String signupUsingParam(Model model) {

		System.out.println("Inside signupUsingParam");

		return "signupUsingParam";
	}

	@RequestMapping(path = "/processSignupUsingParam", method = RequestMethod.POST)
	public String processformSignupUsingParam(HttpServletRequest request, @RequestParam(name = "name", required = false, defaultValue = "No Name Provided") String name) {

		System.out.println("Inside processformSignupUsingParam");

		System.out.println(request.getParameter("email"));
		System.out.println(name);

		return "signupUsingParam";
	}

	@RequestMapping("/signupUsingModelAttribute")
	public String signupUsingModelAttribute(Model model) {

		System.out.println("Inside signupUsingModelAttribute");

		return "signupUsingModelAttribute";
	}

	@RequestMapping(path = "/processSignupUsingModelAttribute", method = RequestMethod.POST)
	public String processSignupUsingModelAttribute(@ModelAttribute User user, Model m) {

		System.out.println("Inside processSignupUsingModelAttribute");

		System.out.println(user.getEmail());
		System.out.println(user.getName());

		System.out.println("we can use or dont use model as per requiremnt, modelAttribute will map req param to model and also will put in model object");

		return "signupUsingModelAttribute_success";
	}

	@ModelAttribute
	public void commonData(Model m) {

		System.out.println("Inside commonData");

		m.addAttribute("common_message", "We can use @ModelAttribute at handler level this will execute each time when new request will come, to serve common data.");

	}

	@RequestMapping("/signupUsingORM")
	public String signupUsingORM(Model model) {

		System.out.println("Inside signupUsingORM");

		return "signupORM";
	}

	@RequestMapping(path = "/processSignupUsingORM", method = RequestMethod.POST)
	public String processForm3(@ModelAttribute com.ng.spring.mvc.orm.model.User user, BindingResult result, Model m) throws Exception {

		System.out.println("Inside processSignupUsingORM");

		System.out.println(user.getEmail());
		System.out.println(user.getName());

		if (result.hasErrors()) {

			System.out.println("error inside hendler" + result);
			m.addAttribute("error", result.toString());

			return "signupORM";
		}

		if (user.getAge() < 0) {

			throw new Exception("invalid age");
		}

		System.out.println("we can use or dont use model as per requiremnt, modelAttribute will map req param to model and also will put in model object");

		int id = userService.save(user);

		user.setId(id);

		return "signupORM_success";
	}

	@RequestMapping("/redirectUsingResponse")
	public void redirectUsingResponse(HttpServletResponse response, Model m) throws IOException {

		System.out.println("Inside redirectUsingResponse");

		response.sendRedirect("modelwithStaticContent");

	}

	@RequestMapping("/redirectUsingRedirectPrefix")
	public String redirectUsingRedirectPrefix() {

		System.out.println("Inside redirectUsingRedirectPrefix");

		return "redirect:/signupUsingParam";

	}

	@RequestMapping("/redirectUsingRediretView")
	public RedirectView redirectUsingRediretView() {

		System.out.println("Inside redirectUsingRediretView");

		RedirectView redirect = new RedirectView();

		redirect.setUrl("signupUsingORM");

		return redirect;

	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExceptionHandler(Model m) {

		m.addAttribute("error", "Null Exception Occured");
		return "Error";

	}

	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler() {

		return "Error";

	}

}
