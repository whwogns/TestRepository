package com.mycompany.myapp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam13CookieAndSessionController {
	
	//<쿠키생성>
	@RequestMapping("/cookie/exam01")
	public String exam01(HttpServletResponse response) throws Exception{
		
		//쿠키생성(서버에서 쿠키생성시킨것임)
		Cookie cookie1 = new Cookie("name1","hongkildong"); // 쿠키는 헤더에 포함되므로 아스키문자가 들어가야함. 
		
		String name2 = "홍길동";
		name2 = URLEncoder.encode(name2, "UTF-8"); 	//URL인코딩
		Cookie cookie2 = new Cookie("name2", name2);   //한글은 아스키코드로 포함시킬수없다. 그러므로  url인코딩 시켜서 16진수 아스키코드로 만들어줘야함
		cookie2.setMaxAge(30*24*60*60);		//쿠키가 살아있는 최대 기간  -- 이렇게 하면 클라이언트 하드디스크에 저장된다
		
		//쿠키를 응답 헤더에 추가
		response.addCookie(cookie1); //접두사 set은 바꾸는것 add는 계속 추가하는 의미    응답http에 쿠키를 헤더에 붙여서 준다
		response.addCookie(cookie2); 
		
		return "cookie/exam01";
		
		
	}
	
	//<쿠키읽기>
	//스프링다운 코딩이 아니다.
//	@RequestMapping("/cookie/exam02")
//	public String exam02(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
//		String name1 = null;
//		String name2 = null;
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies){
//			if(cookie.getName().equals("name1")){
//				name1 = cookie.getValue();
//			}else if(cookie.getName().equals("name2")){
//				name2 = cookie.getValue();
//				name2 = URLDecoder.decode(name2,"UTF-8");
//			}
//		}
//		model.addAttribute("name1",name1);
//		model.addAttribute("name2",name2);
//		return "cookie/exam02";
//	}
	
	//<쿠키읽기>
	//스프링다운 코드
	@RequestMapping("/cookie/exam02")
	public String exam02(
			@CookieValue(defaultValue="") String name1,
			@CookieValue(defaultValue="") String name2,
			Model model) throws UnsupportedEncodingException{
		
		model.addAttribute("name1",name1);
		model.addAttribute("name2",name2);
		return "cookie/exam02";
	}
	
	
	
	//<쿠키삭제>
	@RequestMapping("/cookie/exam03")
	public String exam03(HttpServletResponse response){
		Cookie cookie1 = new Cookie("name1","");
		Cookie cookie2 = new Cookie("name2","");
		//쿠키삭제
		cookie1.setMaxAge(0);  //만료일을 0으로 주면 생성되자마자 만료하여 제거됨
		cookie2.setMaxAge(0);
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "redirect:/";
	}
}









