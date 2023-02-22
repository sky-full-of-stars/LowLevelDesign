package com.example.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private String name;
    private String description;
    private boolean simplifyExpense;
    private List<User> users;
    private List<Expense> expenseHistory;
    private List<SimplifiedBalance> balances;
}
