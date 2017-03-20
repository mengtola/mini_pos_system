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
import com.pos.domain.Categories;

@Controller
public class CategoryController {
	
	CategoryDao dao = new CategoryDao();

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView index(){
		
		
		return new ModelAndView("category/index","cat_list",dao.list());
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public ModelAndView add(Model model){
		model.addAttribute("categories",new Categories());
		//System.out.println(user.get(1).getName());
		return new ModelAndView("category/add");
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Categories categories,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		if (dao.addCategory(categories) != null) {
			response.sendRedirect("/category.html");
		}
		return new ModelAndView("category/add");
	}
	
}
