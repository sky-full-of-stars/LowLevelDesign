package com.example.splitwise;

import com.example.splitwise.db.SplitwiseInventory;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;

import java.util.ArrayList;

@SpringBootApplication
public class SplitwiseApplication {

    private SplitwiseInventory splitwiseInventory = null;

    @PostConstruct
    private SplitwiseInventory createInventory() {
        if(null == splitwiseInventory){
            splitwiseInventory = new SplitwiseInventory(new ArrayList<>(), new ArrayList<>());
            return splitwiseInventory;
        }
        return splitwiseInventory;
    }

    public static void main(String[] args) {

        SpringApplication.run(SplitwiseApplication.class, args);


    }

}
