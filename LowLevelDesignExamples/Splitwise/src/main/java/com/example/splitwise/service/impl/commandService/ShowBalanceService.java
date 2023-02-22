package com.example.splitwise.service.impl.commandService;

import com.example.splitwise.model.Command;
import com.example.splitwise.model.SimplifiedBalance;
import com.example.splitwise.service.ExecuteCommandService;

import java.util.List;

public class ShowBalanceService extends ExecuteCommandService {
    @Override
    public void validate(Command command) {

    }

    @Override
    public void execute(Command command) {
        String groupName = command.getParams().get(1);
        List<SimplifiedBalance> simplifiedBalances = this.splitwiseInventory.getGroups().stream().
                filter(v -> v.getName().equals(groupName)).findFirst().get().getBalances();
        System.out.println(simplifiedBalances);
    }
}
