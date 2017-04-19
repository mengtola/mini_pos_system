package com.pos.web;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

import com.pos.dao.CustomerDao;
import com.pos.dao.ProductDao;
import com.pos.dao.SaleDao;
import com.pos.dao.UserDao;
import com.pos.domain.Customers;
import com.pos.domain.Products;
import com.pos.domain.SaleDetails;
import com.pos.domain.Sales;
import com.post.model.SaleAdd;
import com.post.model.SaleProduct;

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
		return new ModelAndView("sale/index");
	}
	
	@RequestMapping(value = "/sale/add", method = RequestMethod.GET)
	public ModelAndView add(Model model,Map<String,Object> map){
		model.addAttribute("saleadd",new SaleAdd());
		
		List<Customers> customer_list = new CustomerDao().list();
		List<Products> product_list = new ProductDao().list();
		
		map.put("customer_list", customer_list);
		map.put("product_list", product_list);
		
		map.put("dashboard","Sale");
		return new ModelAndView("sale/edit");
	}
	
	@RequestMapping(value = "/sale/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute SaleAdd saleadd,HttpServletRequest request,HttpServletResponse response,Model model,Map<String,Object> map) throws IOException{

		Sales sale = new Sales();
		sale.setCustomer(new CustomerDao().findCustomerById(saleadd.getCusId()));
		sale.setSaleDate(new Date());
		sale.setUserEdit(new Date());
		sale.setUser(new UserDao().findUsersById(Integer.parseInt(request.getSession(true).getAttribute("UserId").toString())));
		
		Set<SaleDetails> saleDetail = new HashSet<SaleDetails>();
		for (SaleProduct saleProduct : saleadd.getSaleProduct()) {
			SaleDetails detail = new SaleDetails();
			ProductDao productDao = new ProductDao();
			detail.setSale(sale);
			detail.setProId(productDao.findProductByCode(saleProduct.getProCode()).getProId());
			detail.setProduct(productDao.findProductById(detail.getProId()));
			detail.setSalePrice(saleProduct.getSalePrice());
			detail.setSaleQty(saleProduct.getSaleQty());
			saleDetail.add(detail);
			
		}
		
		sale.setSaleDetails(saleDetail);
		
		dao.addSale(sale);
		response.sendRedirect("/sale.html");
		
		
		map.put("dashboard","Sale");
		return new ModelAndView("sale/edit");
	
	}
	
	@RequestMapping(value = "/sale/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id,Model model,Map<String,Object> map){
		Sales sales = dao.findSaleById(id);
		SaleAdd saleAdd = new SaleAdd();
		saleAdd.setCusId(sales.getCusId());
	
		ArrayList<SaleProduct> saleProductList = new ArrayList<SaleProduct>();
		for(SaleDetails item : sales.getSaleDetails()){
			SaleProduct saleProduct = new SaleProduct();
			saleProduct.setProCode(item.getProduct().getProCode());
			saleProduct.setSalePrice(item.getSalePrice());
			saleProduct.setSaleQty(item.getSaleQty());
			saleProductList.add(saleProduct);
		}
		
		saleAdd.setSaleProduct(saleProductList);

		model.addAttribute("saleadd",saleAdd);
		model.addAttribute("saleProduct",saleProductList);
		
		List<Customers> customer_list = new CustomerDao().list();
		List<Products> product_list = new ProductDao().list();
		
		map.put("customer_list", customer_list);
		map.put("product_list", product_list);
		
		map.put("dashboard","Sale");
		return new ModelAndView("sale/edit");
	}
	
	@RequestMapping(value = "/sale/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") int id,@ModelAttribute SaleAdd saleadd,HttpServletRequest request,HttpServletResponse response,Model model,Map<String,Object> map) throws IOException{

		Sales tbl = dao.findSaleById(id);
		
		tbl.setCustomer(new CustomerDao().findCustomerById(saleadd.getCusId()));
		tbl.setUserEdit(new Date());
		tbl.setUser(new UserDao().findUsersById(Integer.parseInt(request.getSession(true).getAttribute("UserId").toString())));
		
		Set<SaleDetails> saleDetail = new HashSet<SaleDetails>();
		for (SaleProduct saleProduct : saleadd.getSaleProduct()) {
			SaleDetails detail = new SaleDetails();
			ProductDao productDao = new ProductDao();
			detail.setSale(tbl);
			detail.setProId(productDao.findProductByCode(saleProduct.getProCode()).getProId());
			detail.setProduct(productDao.findProductById(detail.getProId()));
			detail.setSalePrice(saleProduct.getSalePrice());
			detail.setSaleQty(saleProduct.getSaleQty());
			saleDetail.add(detail);
			
		}
		
		tbl.setSaleDetails(saleDetail);
		
		dao.updateSale(tbl);
		response.sendRedirect("/sale.html");
		
	 

		map.put("dashboard","Sale");
		return new ModelAndView("sale/edit");
	
	}
	
}
