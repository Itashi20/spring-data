package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mainapp")
public class ResController {

//	@RequestMapping(value="/welcome",method=RequestMethod.GET)
//	@ResponseBody
//		public String sayWelcome() {
//		return "welcome to Spring MVC";
//	}
		//@RequestMapping(value="/login",method=RequestMethod.GET)
		//@ResponseBody
	@GetMapping("/login")
		public String login() {
			return "login";
		}
		
	@GetMapping("/register")
		//@RequestMapping(value="/register",method=RequestMethod.GET)
		//@ResponseBody
	public String register() {
		return "register";
	}
	}
	
		

