package com.lld.onlinemarketplace.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    //@NonNull
    protected String name;
    //@NonNull
    protected String email;
    //@NonNull
    protected String password;

    public User( String name, String email,  String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    User(){

    }
}
