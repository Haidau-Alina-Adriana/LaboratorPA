package com.company;

public class Book extends Item {
    private String authors;
    private int publishYear;

    public Book(){}

    public Book(String id, String title, String location, String authors, int publishYear) {
        super(id, title, location);
        this.authors = authors;
        this.publishYear = publishYear;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors='" + authors + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
