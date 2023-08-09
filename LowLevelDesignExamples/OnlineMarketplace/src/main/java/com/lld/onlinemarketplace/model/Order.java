package com.lld.onlinemarketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private String orderId;
    private List<CartItem> items;
    private double totalAmount;
    private String shippingAddress;
    private String paymentInfo;
    private Date orderDate;

}
