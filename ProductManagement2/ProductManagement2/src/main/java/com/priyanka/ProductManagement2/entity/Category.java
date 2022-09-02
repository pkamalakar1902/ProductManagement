package com.priyanka.ProductManagement2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category  implements Serializable {
	
	@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int id;

	private String type;
	
	@OneToMany(cascade= CascadeType.ALL,mappedBy ="category")
	private List<Product> products;

	public Category(int id, String type, List<Product> products) {
		super();
		this.id = id;
		this.type = type;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", type=" + type + ", products=" + products + "]";
	}

}