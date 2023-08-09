package com.lld.onlinemarketplace.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    protected String name;
    @NonNull
    protected String email;
    @NonNull
    protected String password;

    public User(@NonNull String name, @NonNull String email, @NonNull String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    User(){

    }
}
