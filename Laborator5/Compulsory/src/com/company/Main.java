package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.testToString();
        app.testSave();
        app.testLoad();
    }

    private void testSave() {
        Catalog catalog = new Catalog("MyRefs");
        var book = new Article("article1", "The Ultimate Productivity Hack is Saying No", "https://jamesclear.com/saying-no", "James Clear");
        var article = new Book("book1", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "Donald E. Knuth", 1967);
        catalog.add(book);
        catalog.add(article);
        try {
            catalog.save(catalog, "C:\\Users\\Asus\\Documents\\GitHub\\LaboratorPA\\Laborator5\\Compulsory\\out.json");
            System.out.println("Test save complete.");
        } catch (IOException e) {
            System.out.println("Unexpected error at saving the file!");
            e.printStackTrace();
        }
    }

    private void testLoad() {
        Catalog catalog = new Catalog();
        try {
            catalog = catalog.load("C:\\Users\\Asus\\Documents\\GitHub\\LaboratorPA\\Laborator5\\Compulsory\\out.json");
            System.out.println(catalog);
            System.out.println("Test load complete.");
        }catch (IOException e){
            System.out.println("Unexpected error at loading the file!");
        }
    }
    private void testToString(){
        Catalog catalog = new Catalog("MyRefs");
        var book = new Article("article1", "The Ultimate Productivity Hack is Saying No", "https://jamesclear.com/saying-no", "James Clear");
        var article = new Book("book1", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "Donald E. Knuth", 1967);
        catalog.add(book);
        catalog.add(article);
        System.out.println(catalog.toString());
        System.out.println("Test toString complete.");
    }
}
