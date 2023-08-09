package com.lld.onlinemarketplace.repo;

import com.lld.onlinemarketplace.exception.UserExistsException;
import com.lld.onlinemarketplace.exception.UserNotFoundException;
import com.lld.onlinemarketplace.model.MarketplaceUser;
import com.lld.onlinemarketplace.model.MarketplaceUserAccount;
import com.lld.onlinemarketplace.model.Product;
import com.lld.onlinemarketplace.model.User;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//should I call it inventory?
@Data
public class Marketplace {

    private static Marketplace instance;

    private Map<String, User> users = new HashMap<>();
    private Map<String, Product> products = new HashMap<>();
    private Map<String, MarketplaceUserAccount> userAccounts = new HashMap<>();

    public static synchronized Marketplace getInstance() {

        if (instance == null)
            instance = new Marketplace();
        return instance;
    }

}
