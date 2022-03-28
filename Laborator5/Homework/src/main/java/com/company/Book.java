package com.company;

public class Book extends Item {
    private String authors;
    private int publishYear;
    private String category;
    private String language;

    public Book() {
    }

    public Book(String id, String title, String location, String authors, int publishYear, String category, String language)
            throws InvalidData {
        super(id, title, location);
        if (authors.equals("")) {
            throw new InvalidData("Empty data!");
        }
        this.authors = authors;
        this.category = category;
        this.language = language;
        if (publishYear < 1000 || publishYear > 2025) {
            throw new InvalidData("Invalid year!");
        }
        this.publishYear = publishYear;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) throws InvalidData {
        if (authors.equals("")) {
            throw new InvalidData("Empty data!");
        }
        this.authors = authors;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) throws InvalidData {
        if (publishYear < 1000 || publishYear > 2025) {
            throw new InvalidData("Invalid year!");
        }
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
