package com.company;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Catalog catalog = new Catalog("MyRefs");
        var book = new Article("article1", "The Ultimate Productivity Hack is Saying No", "https://jamesclear.com/saying-no", "James Clear", 2020);
        var article = new Book("book1", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "Donald E. Knuth", "education", "english", 1967);
        catalog.add(book);
        catalog.add(article);
        String path = "C:\\Users\\Asus\\Documents\\GitHub\\LaboratorPA\\Laborator5\\Compulsory\\out.json";
        app.testToString(catalog);
        app.testSave(catalog, path);
        app.testLoad(path);
    }

    private void testSave(Catalog catalog, String path) {
        try {
            catalog.save(catalog, path);
            System.out.println("Test save complete.");
        } catch (Exception e) {
            System.out.println("Unexpected error at saving the file!");
            e.printStackTrace();
        }
    }

    private void testLoad(String path) {
        Catalog catalog = new Catalog();
        try {
            catalog = catalog.load(path);
            System.out.println(catalog);
            System.out.println("Test load complete.");
        } catch (Exception e) {
            System.out.println("Unexpected error at loading the file!");
        }
    }

    private void testToString(Catalog catalog) {
        catalog.toString(catalog);
        System.out.println("Test toString complete.");
    }
}
