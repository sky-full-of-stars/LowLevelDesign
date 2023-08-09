package com.lld.onlinemarketplace.service;

import com.lld.onlinemarketplace.model.*;
import com.lld.onlinemarketplace.repo.Marketplace;

import java.util.*;

public class AccountService {

    Marketplace marketplace = Marketplace.getInstance();
    private Map<String, MarketplaceUserAccount> userAccounts = marketplace.getUserAccounts();

    ProductService productService = new ProductService();

    public void addToCart(String userId, String productId, int quantity) {
        MarketplaceUserAccount userAccount = getAccountForUserId(userId);
        List<CartItem> cartItemList = userAccount.getUserCart().getCartItemList();
        Optional<CartItem> existingItem = cartItemList.stream().filter(item -> item.getProductId().equals(productId)).findFirst();

        if (existingItem.isPresent()) {
            int updatedQuantity = existingItem.get().getQuantity() + quantity;
            existingItem.get().setQuantity(updatedQuantity);
        } else {
            cartItemList.add(new CartItem(productId, quantity));
        }
    }

    public List<CartItem> getCart(String userId) {
        MarketplaceUserAccount userAccount = getAccountForUserId(userId);
        return  userAccount.getUserCart().getCartItemList();
    }

    public List<Order> getOrderHistory(String userId) {
        MarketplaceUserAccount userAccount = getAccountForUserId(userId);
        return userAccount.getOrders();
    }

    public void checkout(String userId) {
        MarketplaceUserAccount userAccount = getAccountForUserId(userId);
        List<CartItem> cart = getCart(userId);
        if(cart.isEmpty()){
            return;
        }

        //compute total price, can handle out of stock here
        List<CartItem> orderedItems = new ArrayList<>();
        double totalAmount = 0.0;
        for (CartItem item : cart) {
            Product product = productService.getProduct(item.getProductId());
            if (product != null && product.getQuantity() >= item.getQuantity()) {
                orderedItems.add(item);
                totalAmount += (product.getPrice() * item.getQuantity());
                product.setQuantity(product.getQuantity() - item.getQuantity());
            }
        }

        //push order created to his history
        List<Order> orderHistory = userAccount.getOrderHistory();
        if (!orderedItems.isEmpty()) {
            Order order = new Order(UUID.randomUUID().toString(),orderedItems, totalAmount,
                    userAccount.getAddress(), "Credit Card", new Date());
            orderHistory.add(order);
            cart.clear();
        }

    }

    //handle user not found here, if necessary
    private MarketplaceUserAccount getAccountForUserId(String userId){
        return userAccounts.get(userId);
    }

}
