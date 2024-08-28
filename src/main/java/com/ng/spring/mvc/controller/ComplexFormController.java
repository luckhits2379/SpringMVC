package com.ng.spring.mvc.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ng.spring.mvc.model.Student;

@Controller
public class ComplexFormController {

	@RequestMapping(path = "/complexForm")
	public String complexForm() {

		System.out.println("inside complexForm");

		return "complexForm";

	}

	@RequestMapping(value = "/processComplexForm")
	public String processForm(@ModelAttribute Student student) {

		System.out.println(student);

		return "complexForm_success";

	}

	@RequestMapping(value = "/fileUpload")
	public String fileUpload() {

		System.out.println("inside fileUpload");

		return "FileUpload";

	}

	@RequestMapping(path = "/processUpload", method = RequestMethod.POST)
	public String upload(@RequestParam("file1") CommonsMultipartFile file, HttpSession httpSession, Model model) {

		try {

			System.out.println("inside upload");

			System.out.println(file.getName());
			System.out.println(file.getOriginalFilename());
			System.out.println(file.getSize());
			System.out.println(file.getContentType());

			byte[] fileByteArr = file.getBytes();

			// Path where eclipse deploys the application, so that image will be deleted
			// once redploys
			String contextPath = httpSession.getServletContext().getRealPath("/");
			String filePath = contextPath + "WEB-INF/Resources/Images/" + file.getOriginalFilename();

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				fos.write(fileByteArr);
			}

			model.addAttribute("fileName", file.getOriginalFilename());

			// use command + Shift + G, to go to file path
			System.out.println(filePath);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "FileUploadSuccess";

	}

}
