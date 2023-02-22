package com.example.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private Set<Group> groupsJoined;

    public void addGroups(Group group){
        this.groupsJoined.add(group);
    }
}
