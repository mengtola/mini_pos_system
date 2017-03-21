package com.pos.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pos.dao.BrandDao;
import com.pos.dao.CategoryDao;
import com.pos.dao.ProductDao;
import com.pos.domain.Brands;
import com.pos.domain.Categories;
import com.pos.domain.Products;

@Controller
public class ProductController {
	
	ProductDao dao = new ProductDao();
	
	/*@Autowired
	private ConversionService conversionService;*/

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView index(){
		
		
		return new ModelAndView("product/index","pro_list",dao.list());
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("products",new Products());
		
		List<Categories> category_list = new CategoryDao().list();
		List<Brands> brand_list = new BrandDao().list();
		
		map.put("category_list", category_list);
		map.put("brand_list", brand_list);
		return new ModelAndView("product/add");
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Products products,HttpServletRequest request,HttpServletResponse response,BindingResult bindingResult, Model model) throws IOException{
		 
		if (bindingResult.hasErrors()) {
			 if (dao.addProduct(products) != null) {
					response.sendRedirect("/product.html");
				}
	      }

		
		return new ModelAndView("product/add");
	}
	
	/*@InitBinder("Categories")
	public void initBinderCategory(@RequestParam("category")String category, WebDataBinder binder){
	    binder.setConversionService(conversionService);
	}
	
	@InitBinder("Brands")
	public void initBinderBrand(@RequestParam("brand")String brand, WebDataBinder binder){
	    binder.setConversionService(conversionService);
	}*/
	
}
