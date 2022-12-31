package com.example.librarymanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookCopy {
    private String bookCopyId;
    private Book book;
}
