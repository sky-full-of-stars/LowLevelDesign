package com.lld.onlinemarketplace.service;

import com.lld.onlinemarketplace.model.Order;

import java.util.List;

public interface OrderOperation {
    public List<Order> getOrderHistory();
    public void checkout();
}
