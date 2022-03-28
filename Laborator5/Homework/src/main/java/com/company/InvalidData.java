package com.company;

public class InvalidData extends Exception {
    public InvalidData(Exception e) {
        super(e);
    }

    public InvalidData(String message) {
        super(message);
    }
}
