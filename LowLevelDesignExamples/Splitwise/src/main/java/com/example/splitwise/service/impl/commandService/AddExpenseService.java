package com.example.splitwise.service.impl.commandService;

import com.example.splitwise.enums.ExpenseShareType;
import com.example.splitwise.model.Command;
import com.example.splitwise.model.SimplifiedBalance;
import com.example.splitwise.service.ExecuteCommandService;
import com.example.splitwise.service.ExpenseSharable;
import com.example.splitwise.service.factory.ExpenseTypeFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AddExpenseService extends ExecuteCommandService {
    private ExpenseTypeFactory expenseTypeFactory = new ExpenseTypeFactory();

    @Override
    public void validate(Command command) {

    }

    @Override
    public void execute(Command command) {
        List<String> params = command.getParams();
        String groupName = params.get(0);
        String payee = params.get(1);
        double moneySpent = Double.parseDouble(params.get(2));
        int numOfSharedUsers = Integer.parseInt(params.get(3));
        List<String> users = params.subList(4, numOfSharedUsers+1);
        ExpenseShareType shareType = ExpenseShareType.valueOf(params.get(4+numOfSharedUsers+1));
        List<Double> shares = params.subList(4+numOfSharedUsers+2, params.size()+1).
                stream().map(Double::parseDouble).collect(Collectors.toList());

        ExpenseSharable expenseService = expenseTypeFactory.getExpenseServiceByType(shareType);
        List<SimplifiedBalance> balances = expenseService.calculateShare(moneySpent,splitwiseInventory.getUsersForUsernames(users), splitwiseInventory.getUserByName(payee), shares);
        balances.forEach(v -> v.setOwedTo(this.splitwiseInventory.getUserByName(payee)));

        this.splitwiseInventory.getGroups().stream().
                filter(v -> v.getName().equals(groupName)).
                findFirst().get().setBalances(balances);
    }
}
