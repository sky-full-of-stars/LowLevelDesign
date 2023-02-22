package com.example.splitwise.service.impl.expenseService;

import com.example.splitwise.model.SimplifiedBalance;
import com.example.splitwise.model.User;
import com.example.splitwise.service.ExpenseSharable;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class EqualShare implements ExpenseSharable {
    @Override
    public List<SimplifiedBalance> calculateShare(double totalAmount, List<User> owedBy,User owedTo, List<Double> values) {
        List<SimplifiedBalance> balances = new ArrayList<>();
        int totalNumOfPeopleSharing = owedBy.size();
        double eachPersonShare = totalAmount/totalNumOfPeopleSharing;
        owedBy.forEach(user -> balances.add(new SimplifiedBalance(eachPersonShare, user, owedTo)));
        return balances;
    }

    @Override
    public boolean validate(double totalAmount, List<Double> values) {
        return true;
    }
}
