package com.example.splitwise.enums;

public enum CommandType {
    ADD_USER(2), CREATE_GROUP(2), ADD_EXPENSE(6), SHOW_BALANCE(1);

    private int numOfParams;
    CommandType(int numOfParams) {
        this.numOfParams = numOfParams;
    }
}
