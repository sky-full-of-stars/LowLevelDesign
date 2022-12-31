package com.example.librarymanagementsystem;

import com.example.librarymanagementsystem.service.ApplicationDriverService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LibraryManagementSystemApplication {

    public static final String EXIT = "exit";

    public static void main(String[] args) {

        System.out.println("Welcome to library management application");
        Scanner scanner = new Scanner(System.in);

        String command = scanner.next();
        List<String> params = Arrays.stream(command.split(",")).toList();

        if(EXIT.equals(params.get(0))) {
            System.out.println("Exiting from library management application");
            System.exit(1);
        }

        ApplicationDriverService.driver(params);
    }

}
