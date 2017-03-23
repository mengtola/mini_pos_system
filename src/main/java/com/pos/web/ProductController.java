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
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView index(Model model, Integer offset, Integer maxResults,Map<String,Object> map){
		model.addAttribute("pro_list", dao.list(offset, maxResults));
		model.addAttribute("count", dao.count());
		model.addAttribute("offset", offset);
		
		map.put("dashboard","Product");
		
		return new ModelAndView("product/index");
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("products",new Products());
		
		List<Categories> category_list = new CategoryDao().list();
		List<Brands> brand_list = new BrandDao().list();
		
		map.put("category_list", category_list);
		map.put("brand_list", brand_list);
		
		map.put("dashboard","Product");
		return new ModelAndView("product/edit");
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute Products products,HttpServletRequest request,HttpServletResponse response, Model model, Map<String,Object> map) throws IOException{
		 
		//load category object  -- check category is existed?
		products.setCategory(new CategoryDao().findCategoryById(products.getCatId()));
		products.setBrand(new BrandDao().findBrandById(products.getBraId()));
		products.setProCode("0135684");
		products.setProActive(true);
		if (dao.addProduct(products) != null) {
				response.sendRedirect("/product.html");
		}
	      

		map.put("dashboard","Product");
		return new ModelAndView("product/edit");
	}
	
	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id,Model model,Map<String,Object> map){
		model.addAttribute("products",dao.findProductById(id));
		
		List<Categories> category_list = new CategoryDao().list();
		List<Brands> brand_list = new BrandDao().list();
		
		map.put("category_list", category_list);
		map.put("brand_list", brand_list);
		
		map.put("dashboard","Product");
		return new ModelAndView("product/edit");
	}
	
	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") int id, @ModelAttribute Products products,HttpServletRequest request,HttpServletResponse response, Model model, Map<String,Object> map) throws IOException{
		 
		Products tbl = dao.findProductById(id);
		tbl.setCatId(products.getCatId());
		tbl.setBraId(products.getBraId());
		tbl.setProName(products.getProName());
		tbl.setQty(products.getQty());
		tbl.setStockPrice(products.getStockPrice());
		tbl.setSalePrice(products.getSalePrice());
		tbl.setProStatus(products.getProStatus());
		tbl.setCategory(new CategoryDao().findCategoryById(products.getCatId()));
		tbl.setBrand(new BrandDao().findBrandById(products.getBraId()));
		
		dao.updateProduct(tbl);
		response.sendRedirect("/product.html");	
	      

		map.put("dashboard","Product");
		return new ModelAndView("product/edit");
	}
	
	
   @ModelAttribute("prostatuslist")
   public Map<String, String> getStatusList()
   {
      Map<String, String> status = new HashMap<String, String>();
      status.put("0", "Used");
      status.put("1", "New");
      return status;
   }

}
