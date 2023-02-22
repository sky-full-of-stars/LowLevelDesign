package com.example.splitwise.service;

import com.example.splitwise.db.SplitwiseInventory;
import com.example.splitwise.model.Command;
import lombok.Data;
import lombok.NoArgsConstructor;

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
