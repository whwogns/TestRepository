
package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam01HomeController {
	private static final Logger lOGGER = LoggerFactory.getLogger(Exam01HomeController.class);

	@RequestMapping("/")
	public String home() {
		lOGGER.info("/요청 처리");
		return "home";
	}
	
}