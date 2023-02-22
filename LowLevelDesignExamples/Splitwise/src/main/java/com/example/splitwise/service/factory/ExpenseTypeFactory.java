package com.example.splitwise.service.factory;

import com.example.splitwise.enums.ExpenseShareType;
import com.example.splitwise.service.ExpenseSharable;
import com.example.splitwise.service.impl.expenseService.EqualShare;
import com.example.splitwise.service.impl.expenseService.ExactShare;
import com.example.splitwise.service.impl.expenseService.PercentageShare;

public class ExpenseTypeFactory {

    public ExpenseSharable getExpenseServiceByType(ExpenseShareType type){
        if(ExpenseShareType.EQUAL.equals(type)){
            return new EqualShare();
        }
        if(ExpenseShareType.EXACT.equals(type)){
            return new ExactShare();
        }
        if(ExpenseShareType.PERCENT.equals(type)){
            return new PercentageShare();
        }
        return null;
    }
}
