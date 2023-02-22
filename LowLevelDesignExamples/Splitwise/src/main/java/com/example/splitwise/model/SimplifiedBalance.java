package com.example.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimplifiedBalance {
    private double amount;
    private User owedBy;
    private User owedTo;
}
