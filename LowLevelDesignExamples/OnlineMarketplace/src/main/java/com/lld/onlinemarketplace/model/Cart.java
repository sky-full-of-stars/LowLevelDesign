package com.lld.onlinemarketplace.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> cartItemList = new ArrayList<>();
}
