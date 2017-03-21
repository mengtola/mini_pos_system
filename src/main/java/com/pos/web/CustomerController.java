package com.pos.web;


import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.dao.CategoryDao;
import com.pos.dao.CustomerDao;
import com.pos.domain.Categories;
import com.pos.domain.Customers;

@Controller
public class CustomerController {
	
	CustomerDao dao = new CustomerDao();

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView index(){
		
		
		return new ModelAndView("customer/index","cus_list",dao.list());
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public ModelAndView add(Model model){
		model.addAttribute("customers",new Customers());
		//System.out.println(user.get(1).getName());
		return new ModelAndView("customer/add");
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Customers customers,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		if (dao.addCustomer(customers) != null) {
			response.sendRedirect("/customer.html");
		}
		return new ModelAndView("customer/add");
	}
	
}
