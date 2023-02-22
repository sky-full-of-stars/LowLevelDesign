package com.example.splitwise.service;

import com.example.splitwise.db.SplitwiseInventory;
import com.example.splitwise.model.Command;
import com.example.splitwise.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public abstract class ExecuteCommandService {
    protected SplitwiseInventory splitwiseInventory;

    ExecuteCommandService(SplitwiseInventory splitwiseInventory) {
        this.splitwiseInventory = splitwiseInventory;
    }

    public abstract void validate(Command command);
    public abstract void execute(Command command);

}
