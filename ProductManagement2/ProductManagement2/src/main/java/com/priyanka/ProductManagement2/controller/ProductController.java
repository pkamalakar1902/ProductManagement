package com.priyanka.ProductManagement2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.priyanka.ProductManagement2.entity.Product;
import com.priyanka.ProductManagement2.service.ProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	ProductService service;

	@GetMapping(value="/allproducts")
	public List<Product> getAllCategories(){
		
		return service.getAllProduct();
	}
	
	@PostMapping(value="/product/save")
	public String CreateNewProduct(@RequestBody  Product product) {
		Product products=service.CreateNewProduct(product);
		if (products != null) {
			
			return "saved successfully";

		}
		else {
			return "ERR..NOT SAVED";
		}
		
	}
	
	@GetMapping(value="/products/{productid}")
	public Product getProductById(@PathVariable int productid) {
	

		return service.getProductById(productid);
	
	
	}
	
	@PutMapping(value="/product/update")
	public Boolean updateProductById(@RequestBody Product product) {
		return service.updateProductById(product);
	}
	
	@DeleteMapping(value="/products/delete/{productid}")
	public Boolean deleteProductById(@PathVariable int productid) {
		return service.deleteProductById(productid);
		
}
	
}
