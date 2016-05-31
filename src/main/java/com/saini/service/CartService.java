package com.saini.service;

import com.saini.model.Cart;

public interface CartService {

	public void addTocart(Cart cart);
	public void deleteFromCart(int cartId);
	public Cart getFromCart(int cartId);
}
