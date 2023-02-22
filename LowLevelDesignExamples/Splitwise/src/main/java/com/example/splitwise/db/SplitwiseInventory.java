package com.example.splitwise.db;

import com.example.splitwise.model.Group;
import com.example.splitwise.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class SplitwiseInventory {
    private List<Group> groups = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private HashMap<String, User> userByName = new HashMap<>();

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public void addUser(User user){
        users.add(user);
        userByName.put(user.getName(), user);
    }

    public User getUserByName(String name){
        if(userByName.containsKey(name)){
            return userByName.get(name);
        }
        else{
            User user = new User(name,null, new ArrayList<>());
            addUser(user);
            return getUserByName(name);
        }
    }
}
