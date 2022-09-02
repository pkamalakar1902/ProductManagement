package com.priyanka.ProductManagement2.service;

import java.util.List;

import com.priyanka.ProductManagement2.entity.Category;

public interface CatagoryService {

	public List<Category> getAllCategories();
	public Category createNewCategory(Category category);
	public Category getCategoryById(int id);
	public Boolean updateCategory(Category category);
	public Boolean deleteCategoryById(int id);
	
}
