package com.example.librarymanagementsystem.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Book {
    private String bookId;
    private String title;
    private List<Publisher> publisherList;
    private List<Author> authorList;
}
