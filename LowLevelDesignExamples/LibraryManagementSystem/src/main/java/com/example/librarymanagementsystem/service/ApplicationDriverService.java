package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.BookBorrowHistory;
import com.example.librarymanagementsystem.model.BookBorrowOrder;
import com.example.librarymanagementsystem.model.BookCopy;
import com.example.librarymanagementsystem.model.Library;

import java.util.List;

public class ApplicationDriverService {

    //we'll create only one library per application instance.
    private static Library library;
    private static BookBorrowHistory borrowHistory;
    private static BookBorrowOrder bookBorrowOrder;

    private static LibraryService libraryService;
    private static BorrowService borrowService;
    private static ReturnService returnService;
    private static PrintService printService;
    private static SearchService searchService;

    public static void driver(List<String> params) {
        String command = params.get(0);

        switch(command) {
            case "create_library" :
                library = libraryService.createLibrary(Integer.parseInt(params.get(1)));
                break;
            case "add_book":
                libraryService.addBook(library,params.get(1),params.get(2),params.get(3),params.get(4),params.get(5));
                break;
            case "remove_book_copy":
                libraryService.removeBookCopy(library,params.get(1));
                break;

            case "borrow_book":
                borrowService.borrowBook(params.get(1),params.get(2),params.get(3));
                break;
            case "borrow_book_copy":
                borrowService.borrowBookCopy(params.get(1),params.get(2),params.get(3));
                break;

            case "return_book_copy":
                returnService.returnBookCopy(params.get(1));
                break;

            case "print_borrowed":
                List<BookCopy> bookCopyList = borrowService.getBorrowedBooks(params.get(1));
                printService.printBookCopies(bookCopyList);
                break;

            case "search":
                searchService.searchBook(params.get(1), params.get(2));
                break;

            default:
                System.out.println("Command not supported");
        }
    }

}
