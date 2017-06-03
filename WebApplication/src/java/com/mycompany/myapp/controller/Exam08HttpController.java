package com.mycompany.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/http")
public class Exam08HttpController {

	@RequestMapping(value = "/exam01", method = RequestMethod.GET)
	public String exam01Get() {
		System.out.println("exam01Get");
		return "http/exam01";
	}

	@RequestMapping(value = "/exam01", method = RequestMethod.POST)
	public String exam01Post() {
		System.out.println("exam01Post");
		return "http/exam01";
	}

	@RequestMapping("/exam02")
	public String exam02(HttpServletRequest request, Model model) {   // httpsevletrequest는 요청http의 정보를 갖고 있는 객체
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		String type = request.getParameter("type");  //쿼리스트링중 파라미터 값만 뽑아냄
		int bno = Integer.parseInt(request.getParameter("bno")); //위와같음
		String[] hobby = request.getParameterValues("hobby"); // 같은 파라미터의 값이 두개이상이므로 배열로 받는다. 여러개므로 getParameterValues

		String userAgent = request.getHeader("User-Agent");
		if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
			userAgent = "IE11 이하 브라우져";
		} else if (userAgent.contains("Edge")) {
			userAgent = "엣지브라우져";
		} else if (userAgent.contains("chrome")) {
			userAgent = "chrome 브라우져";
		}

		model.addAttribute("method", method);
		model.addAttribute("uri", uri);
		model.addAttribute("queryString", queryString);
		model.addAttribute("type", type);
		model.addAttribute("bno", bno);
		model.addAttribute("hobby", hobby);
		model.addAttribute("userAgent", userAgent);

		return "http/exam02";
	}

	
	
	@RequestMapping("/exam03")   // 위의 방식은 예전방식이고 지금은 이렇게 불러옴
	public String exam03(
			@RequestParam String type, // 파라메타명이 변수명과 같은경우에 값을 가져온다
			@RequestParam("bno") int boardNo,
			@RequestParam int bno,
			@RequestParam String[] hobby,
			@RequestHeader("User-Agent") String userAgent, Model model) {
		//이경우는 변수명이 다르므로 헤더명을 적어주어 명시해줌. 위의 세개도 이렇게 할수있긴하나 생략가능  // 심지어 @RequestParam도 생략가능.

		model.addAttribute("type", type);
		model.addAttribute("bno", boardNo);
		model.addAttribute("hobby", hobby);
		model.addAttribute("userAgent", userAgent);
		return "http/exam02";
	}

}
