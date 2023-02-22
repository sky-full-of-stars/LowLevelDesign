package com.example.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Command {
    private String name;
    private List<String> params;
}
