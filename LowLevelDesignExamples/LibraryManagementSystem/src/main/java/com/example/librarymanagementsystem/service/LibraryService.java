package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.*;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class LibraryService {

    private SearchService searchService;

    public static Library createLibrary(int numOfRacks) {
        return new Library(numOfRacks, new HashMap<>());
    }

    public void addBook(Library library, String bookId, String title, String authorsCommaSeperated,
                        String publishersCommaSeperated, String bookCopyIdsCommaSeperated) {
        List<String> authorsList = Arrays.stream(authorsCommaSeperated.split(",")).toList();
        List<String> publishersList = Arrays.stream(publishersCommaSeperated.split(",")).toList();

        Book book = createBook(bookId, title, authorsList, publishersList);

        List<String> bookCopyIds = Arrays.stream(bookCopyIdsCommaSeperated.split(",")).toList();
        List<BookCopy> bookCopyList = new ArrayList<>();
        bookCopyIds.forEach(v -> bookCopyList.add(new BookCopy(v, book)));

        List<Integer> racksForTheBookCopies = searchService.findRackForBook(library, bookCopyList);
        if(CollectionUtils.isEmpty(racksForTheBookCopies) || bookCopyList.size() != racksForTheBookCopies.size()){
            System.out.println("Rack not available");
        }else {
            HashMap<Integer, Set<BookCopy>> rackBookMap = library.getRackBookMap();
            int availableRacks = racksForTheBookCopies.size();
            for(int rackIdx = 0; rackIdx< availableRacks; rackIdx++){
                int currentRack = racksForTheBookCopies.get(rackIdx);
                BookCopy currentBookCopy = bookCopyList.get(rackIdx);
                rackBookMap.get(currentRack).add(currentBookCopy);
            }
        }

    }

    private Book createBook(String bookId, String title, List<String> authorsList, List<String> publishersList) {
        List<Author> authorList = new ArrayList<>();
        authorsList.stream().forEach(v -> authorList.add(new Author(v)));

        List<Publisher> publisherList = new ArrayList<>();
        publishersList.stream().forEach(v -> publisherList.add(new Publisher(v)));

        Book book = new Book(bookId, title,publisherList, authorList);
        return book;
    }

    public void removeBookCopy(Library library, String bookCopyId) {
    }

}
