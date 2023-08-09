package com.lld.onlinemarketplace.service;

import com.lld.onlinemarketplace.model.CartItem;

import java.util.List;

public interface CartOperation {
    void addToCart(String productId, int quantity);
    List<CartItem> getCart();
}
