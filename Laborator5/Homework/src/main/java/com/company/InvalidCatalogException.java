package com.company;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception e) {
        super("Invalid catalog file.", e);
    }

    public InvalidCatalogException(String message) {
        super(message);
    }
}
