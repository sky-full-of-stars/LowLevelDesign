package com.example.splitwise.service.impl.expenseService;

import com.example.splitwise.model.SimplifiedBalance;
import com.example.splitwise.model.User;
import com.example.splitwise.service.ExpenseSharable;

import java.util.ArrayList;
import java.util.List;

public class PercentageShare implements ExpenseSharable {
    @Override
    public List<SimplifiedBalance> calculateShare(double totalAmount, List<User> owedBy, User owedTo, List<Double> values) {
        List<SimplifiedBalance> balances = new ArrayList<>();
        int totalNumOfPeopleSharing = owedBy.size();
        for(int i=0; i<totalNumOfPeopleSharing; i++){
            balances.add(new SimplifiedBalance(getPercentage(values.get(i), totalAmount),owedBy.get(i), owedTo));
        }
        return balances;
    }

    private double getPercentage(Double percent, double totalAmount) {
        return (percent/100) * totalAmount;
    }

    @Override
    public boolean validate(double totalAmount, List<Double> values) {
        return values.stream().mapToDouble(v -> v).sum() == 100D;
    }
}
