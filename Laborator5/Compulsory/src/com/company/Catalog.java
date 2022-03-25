package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Item> items;

    public Catalog() {
    }

    public Catalog(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public Catalog(String name, List<Item> items) {
        this.name = name;
        this.items = new ArrayList<>();
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public Catalog load(String path) throws IOException {
        Catalog catalog = new ObjectMapper().readValue(new File(path), Catalog.class);
        return catalog;
    }

    public void toString(Catalog catalog) {
        System.out.println("Name: " + catalog.getName() + "\n" + "Content: ");
        for (int i = 0, n = catalog.getItems().size(); i < n; i++) {
            System.out.print("Item " + i + ": \n" + "\tid: " + catalog.getItems().get(i).getId() + "\n\ttitle: " + catalog.getItems().get(i).getTitle()
                    + "\n\tlocation: " + catalog.getItems().get(i).getLocation());
            if (catalog.getItems().get(i) instanceof Book) {
                Book b = (Book) catalog.getItems().get(i);
                System.out.println("\n\tauthor(s): " + b.getAuthors() + "\n\tcategory: " + b.getCategory() + "\n\tlanguage: " + b.getLanguage()
                        + "\n\tpublish year: " + b.getPublishYear());
            } else if (catalog.getItems().get(i) instanceof Article) {
                Article a = (Article) catalog.getItems().get(i);
                System.out.println("\n\tauthor(s): " + a.getAuthors() + "\n\tpublish year: " + a.getPublishYear());
            }
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
