package com.lld.onlinemarketplace;

import com.lld.onlinemarketplace.model.MarketplaceUser;
import com.lld.onlinemarketplace.model.Product;
import com.lld.onlinemarketplace.repo.Marketplace;
import com.lld.onlinemarketplace.service.AccountService;
import com.lld.onlinemarketplace.service.ProductService;
import com.lld.onlinemarketplace.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineMarketplaceApplication {

    private static Marketplace marketplace = Marketplace.getInstance();

    private static UserService userService = new UserService();
    private static ProductService productService = new ProductService();
    private static AccountService accountService = new AccountService();


    public static void main(String[] args) {

        SpringApplication.run(OnlineMarketplaceApplication.class, args);

        MarketplaceUser user = new MarketplaceUser("1","n1", "em1", "pw1");
        userService.createUser(user);
        userService.getUser("1");

        Product product1 = new Product("p1", "pname1", 100, 5, "seller1");
        Product product2 = new Product("p2", "pname2", 10, 5, "seller2");
        productService.addProduct(product1);
        productService.addProduct(product2);

        accountService.addToCart("1", "p1",2);
        accountService.addToCart("1", "p2",2);

        accountService.getCart("1");

        accountService.getOrderHistory("1");
        accountService.checkout("1");
        accountService.getOrderHistory("1");

    }

}
