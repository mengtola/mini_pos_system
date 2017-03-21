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

import com.pos.dao.BrandDao;
import com.pos.domain.Brands;

@Controller
public class BrandController {
	
	BrandDao dao = new BrandDao();

	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public ModelAndView index(){
		
		
		return new ModelAndView("brand/index","bra_list",dao.list());
	}
	
	@RequestMapping(value = "/brand/add", method = RequestMethod.GET)
	public ModelAndView add(Model model){
		model.addAttribute("brands",new Brands());
		return new ModelAndView("brand/add");
	}
	
	@RequestMapping(value = "/brand/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Brands brands,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		if (dao.addBrand(brands) != null) {
			response.sendRedirect("/brand.html");
		}
		return new ModelAndView("brand/add");
	}
	
}
