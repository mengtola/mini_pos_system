package com.pos.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.pos.domain.Users;
import com.pos.dao.*;

@Controller
public class ProductController {

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView index(){
		return new ModelAndView("product/index");
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public ModelAndView add(){
	   	
		testGetList();
		//System.out.println(user.get(1).getName());
		return new ModelAndView("product/add");
	}
	
	public static void testGetList() {
        System.out.println("===========List all items============");
        UserDao dao = new UserDao();
        List<Users> list = dao.list();
        for (Users user : list) {
            System.out.println(String.format("%s; %s", user.getName(), user.getUsername()));
        }
        System.out.println("===========One record============");
        System.out.println(dao.findUsersById(1).getName());
    }
}
