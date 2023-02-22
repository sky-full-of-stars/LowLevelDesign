package com.example.splitwise.service.factory;

import com.example.splitwise.enums.CommandType;
import com.example.splitwise.model.Command;
import com.example.splitwise.service.ExecuteCommandService;
import com.example.splitwise.service.impl.commandService.AddExpenseService;
import com.example.splitwise.service.impl.commandService.AddUserService;
import com.example.splitwise.service.impl.commandService.CreateGroupService;
import com.example.splitwise.service.impl.commandService.ShowBalanceService;

public class CommandFactory {

    ExecuteCommandService getCommandServiceForCommand(Command command){
        if(CommandType.ADD_USER.equals(command.getName())){
            return new AddUserService();
        }
        if(CommandType.CREATE_GROUP.equals(command.getName())){
            return new CreateGroupService();
        }
        if(CommandType.ADD_EXPENSE.equals(command.getName())){
            return new AddExpenseService();
        }
        if(CommandType.SHOW_BALANCE.equals(command.getName())){
            return new ShowBalanceService();
        }
        return null;
    }
}
