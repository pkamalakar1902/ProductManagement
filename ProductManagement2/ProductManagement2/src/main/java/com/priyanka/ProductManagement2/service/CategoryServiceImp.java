package com.priyanka.ProductManagement2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.ProductManagement2.dao.CategoryDao;
import com.priyanka.ProductManagement2.entity.Category;
import com.priyanka.ProductManagement2.entity.Product;
@Service
public class CategoryServiceImp implements CatagoryService{

	
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllCategories() {
		
		return categoryDao.findAll();
	}

	@Override
	public Category createNewCategory(Category category) {
		
		return categoryDao.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		
		return categoryDao.getById(id);
	}

	@Override
	public Boolean updateCategory(Category category) {
		Boolean flag = false;

		if (category.getId() > 0) {

			Optional<Category> categoryfromdatabase = categoryDao.findById(category.getId());

			if (categoryfromdatabase.isPresent()) {

				categoryfromdatabase.get().setProduct(category.getProduct());
				categoryfromdatabase.get().setType(category.getType());

				String saved = categoryDao.save(categoryfromdatabase.get()).toString();
				if (!(saved == null)) {
					flag = true;
				}

			}

		}
		return flag;

	}

	@Override
	public Boolean deleteCategoryById(int id) {
		boolean deleted=false;
		if (id > 0) {

			Optional<Category> product = categoryDao.findById(id);

			if (product.isPresent()) {

				categoryDao.deleteById(id);
				deleted=true;

			}
		}
		return deleted;
	}
	}


