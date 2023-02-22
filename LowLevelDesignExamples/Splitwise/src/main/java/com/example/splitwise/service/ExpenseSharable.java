package com.example.splitwise.service;

import com.example.splitwise.model.SimplifiedBalance;
import com.example.splitwise.model.User;

import java.util.List;

public interface ExpenseSharable {
    List<SimplifiedBalance> calculateShare(double totalAmount, List<User> owedBy,User owedTo, List<Double> values);
    boolean validate(double totalAmount, List<Double> values);
}
