package com.lld.onlinemarketplace.service;

import com.lld.onlinemarketplace.model.Product;
import com.lld.onlinemarketplace.repo.Marketplace;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ProductService {

    Marketplace marketplace = Marketplace.getInstance();
    private Map<String, Product> products = marketplace.getProducts();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
}
