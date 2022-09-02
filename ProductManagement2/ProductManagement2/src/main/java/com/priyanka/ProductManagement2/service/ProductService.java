package com.priyanka.ProductManagement2.service;

import java.util.List;

import com.priyanka.ProductManagement2.entity.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	public Product CreateNewProduct(Product product);
	public Product getProductById(int productid);
	public Boolean updateProductById(Product Product);
	public Boolean deleteProductById(int id);
}
