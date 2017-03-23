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

import com.pos.dao.BrandDao;
import com.pos.domain.Brands;

@Controller
public class BrandController {
	
	BrandDao dao = new BrandDao();

	@RequestMapping(value = "/brand", method = RequestMethod.GET)
	public ModelAndView index(Model model, Integer offset, Integer maxResults, Map<String,Object> map){
		model.addAttribute("bra_list", dao.list(offset, maxResults));
		model.addAttribute("count", dao.count());
		model.addAttribute("offset", offset);
		
		map.put("dashboard","Brand");
		return new ModelAndView("brand/index");
	}
	
	@RequestMapping(value = "/brand/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("brands",new Brands());
		
		map.put("dashboard","Brand");
		return new ModelAndView("brand/edit");
	}
	
	@RequestMapping(value = "/brand/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Brands brands,HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws IOException{
		
		brands.setBraActive(true);
		if (dao.addBrand(brands) != null) {
			response.sendRedirect("/brand.html");
		}
		
		map.put("dashboard","Brand");
		return new ModelAndView("brand/edit");
	}
	
	@RequestMapping(value = "/brand/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id, Model model,Map<String,Object> map){
		
		model.addAttribute("brands",dao.findBrandById(id));
		
		map.put("dashboard","Brand");
		return new ModelAndView("brand/edit");
	}
	
	@RequestMapping(value = "/brand/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") int id, @ModelAttribute Brands brands,HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws IOException{
		
		Brands tbl = dao.findBrandById(id);
		tbl.setBraName(brands.getBraName());
		tbl.setBraActive(true);
		
		dao.updateBrand(tbl);
		response.sendRedirect("/brand.html");
		
		map.put("dashboard","Brand");
		return new ModelAndView("brand/edit");
	}

	
}
