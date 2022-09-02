package com.priyanka.ProductManagement2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.ProductManagement2.dao.ProductDao;
import com.priyanka.ProductManagement2.entity.Product;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	ProductDao productdao;

	@Override
	public List<Product> getAllProduct() {
		return productdao.findAll();
	}

	@Override
	public Product CreateNewProduct(Product product) {

		return productdao.save(product);
	}

	@Override
	public Product getProductById(int productid) {

		return productdao.getById(productid);
	}

	@Override
	public Boolean updateProductById(Product product) {

		Boolean flag = false;

		if (product.getId() > 0) {

			Optional<Product> productfromdatabase = productdao.findById(product.getId());

			if (productfromdatabase.isPresent()) {
				productfromdatabase.get().setProductName(product.getProductName());

				productfromdatabase.get().setCategory(product.getCategory());

				String saved = productdao.save(productfromdatabase.get()).toString();
				if (!(saved == null)) {
					flag = true;
				}

			}

		}
		return flag;
	}

	@Override
	public Boolean deleteProductById(int id) {
		
		boolean deleted=false;
		if (id > 0) {

			Optional<Product> product = productdao.findById(id);

			if (product.isPresent()) {

				productdao.deleteById(id);
				deleted=true;

			}
		}
		return deleted;
	}
}
