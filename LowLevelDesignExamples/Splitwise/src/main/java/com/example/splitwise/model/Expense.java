package com.example.splitwise.model;

import com.example.splitwise.enums.ExpenseShareType;

import java.util.List;

public class Expense {
    private String notes;
    private double totalAmount;
    private User paidBy;
    private List<User> owedBy;
    private ExpenseShareType type;
}
