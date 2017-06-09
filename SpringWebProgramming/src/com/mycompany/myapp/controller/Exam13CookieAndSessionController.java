package com.mycompany.myapp.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.myapp.dto.Exam13Member;

@Controller
@SessionAttributes({"name1", "name2", "member"})  // 각각의 키이름으로 세션에 저장해야할 것들이라는 뜻
public class Exam13CookieAndSessionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam13CookieAndSessionController.class);
	
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
	
//	@RequestMapping("/session/exam04")
//	public String exam04(HttpSession session){   // 자동으로 생성된 session을 받아서 사용
//		//세션에 문자열 정보를 저장
//		session.setAttribute("name1", "hongkildong");
//		session.setAttribute("name2", "홍길동");
//		//세션에 객체를 저장
//		Exam13Member member = new Exam13Member();
//		member.setMname("스프링");
//		session.setAttribute("member", member);
//		return "redirect:/";
//	}
	
	
	@RequestMapping("/session/exam04")
	public String exam04(Model model){
		model.addAttribute("name1","hongkildong");     //name1 name2 member가 세션에 저장된다.  리퀘스트에 저장하는게 기본이지만 위에 세션속성이 정의되어 있다면 세션에 저장된다.
		model.addAttribute("name2","홍길동");
		Exam13Member member = new Exam13Member();
		member.setMname("스프링");
		model.addAttribute("member", member);
		return "redirect:/";
	}
	
	
	
	//how1 -- http를 이용
//	@RequestMapping("/session/exam05")
//	public String exam05(HttpSession session){
//		//세션에서 문자열 정보 가져오기
//		String name1 = (String)session.getAttribute("name1");
//		String name2 = (String)session.getAttribute("name2");
//		Exam13Member member = (Exam13Member)session.getAttribute("member");
//		
//		LOGGER.debug(name1);
//		LOGGER.debug(name2);
//		LOGGER.debug(member.getMname());
//		
//		return "session/exam05";
//	}
	
	
	
	//how2 -- session attribute를 이용
	@RequestMapping("/session/exam05")
	public String exam05(
			@ModelAttribute String name1,                  //@ModelAttribute 는 해당하는 키값으로 세션에 저장된 내용을 가져온다.  순서에 따라 리퀘스트, 세션, 어플리케이션에서 찾아간다.
			@ModelAttribute String name2,                    //모델을 이용하여 저장시켜줬었으니까 modelattribute로 가져옴.
			@ModelAttribute Exam13Member member){
			
//		LOGGER.debug(name1);
//		LOGGER.debug(name2);
//		LOGGER.debug(member.getMname());
		
		return "session/exam05";
	}
	
	
	
	
	
	//-- 세션에서 제거
//	@RequestMapping("/session/exam06")
//	public String exam06(HttpSession session){
	//세션에서 삭제해도 model에는 남아있을수 있다
	//@SessionAttribute대신 HttpSession 만 이용할 경우에 사용
//		session.removeAttribute("name1");
//		session.removeAttribute("name2");
//		session.removeAttribute("member");
//		return "redirect:/";
//	}
	
	@RequestMapping("/session/exam06")   //http로할거면 http로만 하고 모델어트리뷰트를 할거면 그것만해라.
	public String exam06(SessionStatus sessionStatus){  
		//세션에서 삭제해도 model에는 남아있을수 있다
		//@SessionAttribute를 사용할 경우 이용
		sessionStatus.setComplete();    
		return "redirect:/";
	}
}









