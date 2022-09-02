package com.priyanka.ProductManagement2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.ProductManagement2.entity.Category;
import com.priyanka.ProductManagement2.entity.Product;
import com.priyanka.ProductManagement2.service.CatagoryService;
import com.priyanka.ProductManagement2.service.ProductService;

@RestController
@RequestMapping(value="/catagory")
public class CategoryController {

	
	@Autowired
	CatagoryService service;

	@GetMapping(value="/categories")
	public List<Category> getAllCategories(){
		
		return service.getAllCategories();
	}
	
	@PostMapping(value="/addcategories")
	public String createNewCategory(@RequestBody  Category category) {
		Category categories= service.createNewCategory(category);
if (categories != null) {
			
			return "saved successfully";

		}
		else {
			return "ERR..NOT SAVED";
		}
		
	}
	
	@GetMapping(value="/categories/{categoryid}")
	public Category getCategoryById(@PathVariable int categoryid) {
	
	return	service.getCategoryById(categoryid);
		
	}
	
	@PutMapping(value="/updatecategories")
	public Boolean updateCategoryId(@RequestBody Category category) {
		return service.updateCategory(category);
	}
	
	@DeleteMapping(value="/categories/delete/{categoriesid}")
	public Boolean deleteCategoryById(@PathVariable int categoriesid) {
		return service.deleteCategoryById(categoriesid);
		
}
	
}
