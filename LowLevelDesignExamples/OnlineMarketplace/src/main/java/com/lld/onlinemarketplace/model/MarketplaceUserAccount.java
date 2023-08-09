package com.lld.onlinemarketplace.model;

import com.lld.onlinemarketplace.service.CartOperation;
import com.lld.onlinemarketplace.service.OrderOperation;
import com.lld.onlinemarketplace.service.AccountService;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class MarketplaceUserAccount extends MarketplaceUser implements CartOperation, OrderOperation {

    private Cart userCart = new Cart();
    private List<Order> orders = new ArrayList<>();

    private AccountService accountService = new AccountService();
    @Override
    public void addToCart(String productId, int quantity) {
        accountService.addToCart(this.id, productId, quantity);
    }

    @Override
    public List<CartItem> getCart() {
        return accountService.getCart(this.id);
    }

    @Override
    public void checkout() {
        accountService.checkout(this.id);
    }

    @Override
    public List<Order> getOrderHistory(){
        return accountService.getOrderHistory(this.id);
    }
}
