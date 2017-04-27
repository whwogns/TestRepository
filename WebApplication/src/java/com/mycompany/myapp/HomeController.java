package com.mycompany.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(){
		System.out.println("home()");
		return "home";
	}
	@RequestMapping("/html")                         //스프링이기때문에 이렇게 쓴다
	public String html(){
		return "html";
	}
	@RequestMapping("/css/exam01")   //인라인 css
	public String cssExam01(){
		return "css/exam01";
	}
	
		@RequestMapping("/css/exam02")   //도큐먼트 수준의 css
	public String cssExam02(){
		return "css/exam01";
	}
	@RequestMapping("/css/exam03")     //외부 css
	public String cssExam03(){
		return "css/exam03";
	}
	
	@RequestMapping("/javascript/exam01")
	public String javascriptExam01(){
		return "javascript/exam01";
	}
	
	@RequestMapping("/javascript/exam02")
	public String javascripExam02(){
		return "javascript/exam02";
	}
	@RequestMapping("/javascript/exam03")
	public String javascripExam03(){
		return "javascript/exam03";
	}
	@RequestMapping("/javascript/exam04")
	public String javascripExam04(){
		return "javascript/exam04";
	}
	
	@RequestMapping("/javascript/exam05")
	public String javascripExam05(){
		return "javascript/exam05";
	}
	
	@RequestMapping("/javascript/exam06")
	public String javascripExam06(){
		return "javascript/exam06";
	}
	
	@RequestMapping("/javascript/exam07")
	public String javascripExam07(){
		return "javascript/exam07";               //dispatch servlet에서 경로 앞뒤를 이미 설정해놓았기에 이를 생략한 경로만 작성해도 됨.
	}
	
	
	@RequestMapping("/javascript/exam08")
	public String javascripExam08(){
		return "javascript/exam08";               
	}
	
	@RequestMapping("/javascript/exam09")
	public String javascripExam09(){
		return "javascript/exam09";               
	}
	
	@RequestMapping("/javascript/exam10")
	public String javascripExam10(){
		return "javascript/exam10";               
	}
	
	@RequestMapping("/javascript/exam11")
	public String javascripExam11(){
		return "javascript/exam11";               
	}
	
	@RequestMapping("/jquery/exam01")
	public String jqueryExam01(){
		return "jquery/exam01";               
	}
	
	@RequestMapping("/jquery/exam02")
	public String jqueryExam02(){
		return "jquery/exam02";
	}
	
	@RequestMapping("/jquery/exam03")
	public String jqueryExam03(){
		return "jquery/exam03";
	}
	
	@RequestMapping("/jquery/exam04")
	public String jqueryExam04(){
		return "jquery/exam04";
	}
	
	@RequestMapping("/jquery/exam04_html_fragment")
	public String jqueryExam04HtmlFragment(){
		return "jquery/exam04_html_fragment";
	}
	
	@RequestMapping("/jquery/exam04_json")
	public String jqueryExam04Json(){
		return "jquery/exam04_json";
	}
	
	@RequestMapping("/bootstrap/exam01")
	public String bootstrapExam01(){
		return "bootstrap/exam01";
	}
	
	@RequestMapping("/bootstrap/exam02")
	public String bootstrapExam02(){
		return "bootstrap/exam02";
	}
	
	@RequestMapping("/bootstrap/exam03")
	public String bootstrapExam03(){
		return "bootstrap/exam03";
	}
	
	
}
