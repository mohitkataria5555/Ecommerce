package com.VeggiesDelivery.service;

import com.VeggiesDelivery.entity.Cart;

import java.util.List;

public interface CartService {

    Cart getCartById(long id);
    List<Cart> getAllCarts();
    void addCart(Cart cart);
    void updateCart(long id, Cart cart);
    void deleteCart(long id);
}
