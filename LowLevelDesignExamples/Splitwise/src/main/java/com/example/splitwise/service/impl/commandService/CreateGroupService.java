package com.example.splitwise.service.impl.commandService;

import com.example.splitwise.model.Command;
import com.example.splitwise.model.Group;
import com.example.splitwise.model.User;
import com.example.splitwise.service.ExecuteCommandService;

import java.util.*;
import java.util.stream.Collectors;

public class CreateGroupService extends ExecuteCommandService {
    @Override
    public void validate(Command command) {

    }

    @Override
    public void execute(Command command) {
        List<String> params = command.getParams();
        String groupName = params.get(0);
        List<String> userNames = params.subList(1, params.size());

        List<User> users = this.splitwiseInventory.getUsersForUsernames(userNames);
        Group group = new Group(groupName, null, false, users, new ArrayList<>(), new ArrayList<>());
        this.splitwiseInventory.getGroups().add(group);

        updateUsersWithNewGroup(users, group);
    }

    private void updateUsersWithNewGroup(List<User> users, Group group) {
        users.forEach(v -> v.addGroups(group));
    }



}
