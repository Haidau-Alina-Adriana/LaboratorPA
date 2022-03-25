package com.company;

public class Book extends Item {
    private String authors;
    private String category;
    private String language;
    private int publishYear;

    public Book() {
    }

    public Book(String id, String title, String location, String authors, String category, String language, int publishYear) {
        super(id, title, location);
        this.authors = authors;
        this.category = category;
        this.language = language;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors='" + authors + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
