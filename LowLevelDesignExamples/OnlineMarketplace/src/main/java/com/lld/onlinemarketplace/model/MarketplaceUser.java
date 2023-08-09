package com.lld.onlinemarketplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketplaceUser extends User{
    protected String id;
    protected String address;

    public MarketplaceUser(String id, String name, String email, String password) {
        this.id = id;
        super.name = name;
        super.email = email;
        super.password = password;
    }
}
