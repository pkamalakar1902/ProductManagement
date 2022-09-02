package com.priyanka.ProductManagement2.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.ProductManagement2.entity.Product;


@Repository
@Transactional
public interface ProductDao extends JpaRepository<Product, Integer> {

	
	
	
}
