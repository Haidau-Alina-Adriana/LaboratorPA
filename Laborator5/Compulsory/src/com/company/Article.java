package com.company;


public class Article extends Item {
    private String authors;
    private int publishYear;

    public Article() {
    }

    public Article(String id, String title, String location, String author, int publishYear) {
        super(id, title, location);
        this.authors = author;
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
        return "Article{" +
                "author='" + authors + '\'' +
                ", publishYear=" + publishYear +
                '}';
    }
}
