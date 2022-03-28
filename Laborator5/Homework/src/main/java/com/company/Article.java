package com.company;

public class Article extends Item {
    private String authors;
    private int publishYear;

    public Article() {
    }

    public Article(String id, String title, String location, String authors, int publishYear) throws InvalidData {
        super(id, title, location);
        if (authors.equals("")) {
            throw new InvalidData("Empty data!");
        }
        this.authors = authors;
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

    @Override
    public String toString() {
        return "Article{" +
                "author='" + authors + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
