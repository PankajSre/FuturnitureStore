package com.saini.dao;

import java.util.List;

import com.saini.model.Products;

public interface ProductsDAO {

	public void add(Products products);
	public void edit(Products products);
	public void delete(int productId);
	public Products getProduct(int productId);
	public List getAllProducts();
	
}
