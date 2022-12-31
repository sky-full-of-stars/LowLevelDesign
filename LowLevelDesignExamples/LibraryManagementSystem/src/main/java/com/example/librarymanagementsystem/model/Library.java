package com.example.librarymanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Set;

@AllArgsConstructor
@Data
public class Library {
    private int racks;
    private HashMap<Integer, Set<BookCopy>> rackBookMap;
}
