package com.priyanka.ProductManagement2.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="product")
public class Product{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	private String productName;
	

   @ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;


public Product() {
	
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getProductName() {
	return productName;
}


public void setProductName(String productName) {
	this.productName = productName;
}


public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
}


@Override
public String toString() {
	return "Product [id=" + id + ", productName=" + productName + ", category=" + category + "]";
}



	
	

	
	
}
