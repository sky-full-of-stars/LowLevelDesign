package com.example.splitwise.service.impl.commandService;

import com.example.splitwise.model.Command;
import com.example.splitwise.model.User;
import com.example.splitwise.service.ExecuteCommandService;

public class AddUserService extends ExecuteCommandService {
    @Override
    public void validate(Command command) {

    }

    @Override
    public void execute(Command command) {
        String name = command.getParams().get(0);
        String email = command.getParams().get(1);
        this.splitwiseInventory.getUsers().add(new User(name,email, null));
    }

}
