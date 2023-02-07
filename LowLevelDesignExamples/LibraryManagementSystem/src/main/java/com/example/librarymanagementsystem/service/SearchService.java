package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.BookCopy;
import com.example.librarymanagementsystem.model.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SearchService {
    //attribute: book_id, author, publisher
    public void searchBook(String attribute, String value) {
    }

    public List<Integer> findRackForBook(Library library, List<BookCopy> bookCopyList) {
        final HashMap<Integer, Set<BookCopy>> rackBookMap = library.getRackBookMap();
        List<Integer> availableRacks = new ArrayList<>();
        bookCopyList.forEach(bookCopy -> {
            for (int rack : rackBookMap.keySet()) {
                Set<BookCopy> bookCopies = rackBookMap.get(rack);
                if (bookCopies.stream().map(BookCopy::getBook).noneMatch(v -> v.equals(bookCopy))) {
                    availableRacks.add(rack);
                }
            }
        });

        return availableRacks;
    }
}
