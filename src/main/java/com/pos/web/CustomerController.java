package com.pos.web;


import java.util.List;
import java.util.Map;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView index(Model model, Integer offset, Integer maxResults,Map<String,Object> map){
		model.addAttribute("cus_list", dao.list(offset, maxResults));
		model.addAttribute("count", dao.count());
		model.addAttribute("offset", offset);
		
		map.put("dashboard","Customer");
		return new ModelAndView("customer/index");
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("customers",new Customers());
		
		map.put("dashboard","Customer");
		return new ModelAndView("customer/edit");
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Customers customers,HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws IOException{
		
		if (dao.addCustomer(customers) != null) {
			response.sendRedirect("/customer.html");
		}
		
		map.put("dashboard","Customer");
		return new ModelAndView("customer/edit");
	}
	
	@RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id,Model model,Map<String,Object> map){
		model.addAttribute("customers",dao.findCustomerById(id));
		
		map.put("dashboard","Customer");
		return new ModelAndView("customer/edit");
	}
	
	@RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") int id, @ModelAttribute Customers customers,HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws IOException{
		
		Customers tbl = dao.findCustomerById(id);
		tbl.setCusName(customers.getCusName());
		tbl.setCusPhone(customers.getCusPhone());
		
		dao.updateCustomer(tbl);
		response.sendRedirect("/customer.html");
		
		map.put("dashboard","Customer");
		return new ModelAndView("customer/edit");
	}
	
}
