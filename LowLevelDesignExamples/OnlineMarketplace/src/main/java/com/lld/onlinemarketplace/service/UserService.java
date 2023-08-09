package com.lld.onlinemarketplace.service;

import com.lld.onlinemarketplace.exception.UserExistsException;
import com.lld.onlinemarketplace.exception.UserNotFoundException;
import com.lld.onlinemarketplace.model.MarketplaceUser;
import com.lld.onlinemarketplace.model.User;
import com.lld.onlinemarketplace.repo.Marketplace;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Marketplace marketplace = Marketplace.getInstance();
    private Map<String, User> users = marketplace.getUsers();


    public void createUser(MarketplaceUser user) {
        if(users.containsKey(user.getId())){
            throw new UserExistsException();
        }
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        if(users.containsKey(userId)){
            return users.get(userId);
        }
        throw new UserNotFoundException();
    }
}
