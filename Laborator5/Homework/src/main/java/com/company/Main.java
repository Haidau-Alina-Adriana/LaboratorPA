package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new Catalog("MyRefs");
        String path = "out.json";
        String htmlPath = "htmlReport.html";
        AddCommand addCommand = new AddCommand();
        ToStringCommand toStringCommand = new ToStringCommand();
        SaveCommand saveCommand = new SaveCommand();
        LoadCommand loadCommand = new LoadCommand();
        ListCommand listCommand = new ListCommand();
        ViewCommand viewCommand = new ViewCommand();
        ReportCommand reportCommand = new ReportCommand();
        InfoCommand infoCommand = new InfoCommand();

        try {
            var article = new Article("article1", "The Ultimate Productivity Hack is Saying No", "https://jamesclear.com/saying-no", "James Clear", 2020);
            var book = new Book("book1", "The Art of Computer Programming", "C:\\Users\\Asus\\Documents\\GitHub\\LaboratorPA\\Laborator5\\Homework\\The Art Of Computer Programming.pdf", "Donald E. Knuth", 1967, "education", "english");
            System.out.println("----Add Command: ");
            addCommand.loadItem(book);
            addCommand.executeCommand(catalog, book.getId());
            addCommand.loadItem(article);
            addCommand.executeCommand(catalog, article.getId());
            System.out.println("----List Command: ");
            listCommand.executeCommand(catalog, "");
            System.out.println("----Save Command: ");
            saveCommand.executeCommand(catalog, path);
            System.out.println("----Load Command: ");
            Catalog newCatalog = loadCommand.executeCommand(path);
            System.out.println("----ToString Command: ");
            toStringCommand.executeCommand(newCatalog, "");
//            System.out.println("----View Command: ");
//            viewCommand.executeCommand(catalog, book.getId());
//            System.out.println("----Report Command: ");
//            reportCommand.executeCommand(catalog, htmlPath);
            System.out.println("----Info Command:");
            infoCommand.executeCommand(catalog, "");
        } catch (InvalidData | InvalidCatalogException | IOException e) {
            System.out.println(e);
        }
    }

}
