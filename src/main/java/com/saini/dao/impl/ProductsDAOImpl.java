package com.saini.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saini.dao.ProductsDAO;
import com.saini.model.Products;
@Repository
@PersistenceContext
public class ProductsDAOImpl implements ProductsDAO {

	@Autowired
	private SessionFactory session;
	public List getAllProducts() {
		return session.getCurrentSession().createQuery("from Products").list(); 
	}
	public void add(Products products) {
		session.getCurrentSession().save(products);
		
	}
	public void edit(Products products) {
		System.out.println(products.getProductId());
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		Products pd=(Products)s.get(Products.class, new Integer(products.getProductId()));
		pd.setProductId(products.getProductId());
		pd.setName(products.getName());
		pd.setGroupName(products.getGroupName());
		pd.setPrice(products.getPrice());
		pd.setQuantity(products.getQuantity());
		pd.setDescription(products.getDescription());
		s.saveOrUpdate(pd);
		s.flush();
		t.commit();
		s.close();
	}
	public void delete(int productId) {
		Session s=session.openSession();
		Transaction t=s.beginTransaction();
		Products pd=(Products)s.get(Products.class, new Integer(productId));
		s.delete(pd);
		s.flush();
		t.commit();
		s.close();
		
	}
	public Products getProduct(int productId) {
		return (Products)session.getCurrentSession().get(Products.class,productId);
	}

}

