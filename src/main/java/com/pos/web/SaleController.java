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

import com.pos.dao.CustomerDao;
import com.pos.dao.ProductDao;
import com.pos.dao.SaleDao;
import com.pos.domain.Customers;
import com.pos.domain.Products;
import com.pos.domain.Sales;

@Controller
public class SaleController {
	
	SaleDao dao = new SaleDao();
	
	/*@Autowired
	private ConversionService conversionService;*/

	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public ModelAndView index(Model model, Integer offset, Integer maxResults,Map<String,Object> map){
		
		model.addAttribute("sale_list", dao.list(offset, maxResults));
		model.addAttribute("count", dao.count());
		model.addAttribute("offset", offset);
		
		map.put("dashboard","Sale");
		return new ModelAndView("sale/index","sale_list",dao.list());
	}
	
	@RequestMapping(value = "/sale/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("sales",new Sales());
		
		List<Customers> customer_list = new CustomerDao().list();
		List<Products> product_list = new ProductDao().list();
		
		map.put("customer_list", customer_list);
		map.put("product_list", product_list);
		
		map.put("dashboard","Sale");
		return new ModelAndView("sale/edit");
	}
	
	@RequestMapping(value = "/sale/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Sales sales,HttpServletRequest request,HttpServletResponse response,BindingResult bindingResult, Model model,Map<String,Object> map) throws IOException{
		 
		if (bindingResult.hasErrors()) {
			 if (dao.addSale(sales) != null) {
					response.sendRedirect("/sale.html");
				}
	      }

		map.put("dashboard","Sale");
		return new ModelAndView("sale/edit");
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
