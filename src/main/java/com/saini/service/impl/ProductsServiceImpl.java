package com.saini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saini.model.Products;
import com.saini.service.ProductsService;
import com.saini.dao.ProductsDAO;

@Service
public class ProductsServiceImpl implements ProductsService{
 
	@Autowired
	private ProductsDAO productDAO;
	
	@Transactional
	public void add(Products products) {
		productDAO.add(products);
		
	}
	@Transactional
	public void edit(Products products) {
		productDAO.edit(products);
	}
	@Transactional
	public void delete(int productId) {
	
	  productDAO.delete(productId);	
	}
	@Transactional
	public Products getProduct(int productId) {
	return productDAO.getProduct(productId);
	}
	@Transactional
	public List getAllProducts() {
		return productDAO.getAllProducts();
	}
}
