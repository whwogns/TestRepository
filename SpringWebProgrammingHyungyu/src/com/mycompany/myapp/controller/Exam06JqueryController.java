/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ijeongsu
 */
@Controller
public class Exam06JqueryController {
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
}
