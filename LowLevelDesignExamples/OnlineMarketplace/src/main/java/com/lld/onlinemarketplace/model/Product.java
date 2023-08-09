package com.lld.onlinemarketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String sellerId;
}
