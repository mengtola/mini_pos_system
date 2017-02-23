package com.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Login;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView index(){
		
		return new ModelAndView("login/index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView index(@ModelAttribute Login login){
		
		return new ModelAndView("login/index");
	}
	
	
}
