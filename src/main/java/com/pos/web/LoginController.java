package com.pos.web;
import com.pos.dao.UserDao;
import com.pos.domain.Users;
import com.post.model.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView index(Model model){
		model.addAttribute("login",new Login());
		return new ModelAndView("login/index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView index(@ModelAttribute Login login,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		UserDao dao = new UserDao();
		Users user = dao.getUserByAuthentication(login.getUsername(), login.getPassword());
		if( user != null) {
			System.out.println("login success");
			request.getSession().setAttribute("UserId",user.getUserId());
			response.sendRedirect("/");
			
		}
		return new ModelAndView("login/index");
	}
	
	
}
