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
import com.pos.domain.Categories;

@Controller
public class CategoryController {
	
	CategoryDao dao = new CategoryDao();

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView index(Model model, Integer offset, Integer maxResults,Map<String,Object> map){
		model.addAttribute("cat_list", dao.list(offset, maxResults));
		model.addAttribute("count", dao.count());
		model.addAttribute("offset", offset);
		
		map.put("dashboard","Categories");
		return new ModelAndView("category/index");
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("categories",new Categories());
		
		map.put("dashboard","Categories");
		return new ModelAndView("category/edit");
	}
	
	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Categories categories,HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws IOException{
		
		categories.setCatActive(true);
		if (dao.addCategory(categories) != null) {
			response.sendRedirect("/category.html");
		}
		
		map.put("dashboard","Categories");
		return new ModelAndView("category/edit");
	}
	
	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id,Model model,Map<String,Object> map){
		model.addAttribute("categories",dao.findCategoryById(id));
		
		map.put("dashboard","Categories");
		return new ModelAndView("category/edit");
	}
	
	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") int id,@ModelAttribute Categories categories,HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws IOException{
		
		Categories tbl = dao.findCategoryById(id);
		tbl.setCatName(categories.getCatName());
		tbl.setCatActive(true);
		
		dao.updateCategory(tbl);
		response.sendRedirect("/category.html");
		
		map.put("dashboard","Categories");
		return new ModelAndView("category/edit");
	}
	
}
