package com.company;


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

    public void list() {
        System.out.println("Items: ");
        for (Item item : items) {
            System.out.print("Item: " + item.getId() + ", " + item.getTitle()
                    + ", " + item.getLocation());
            if (item instanceof Book) {
                Book b = (Book) item;
                System.out.println(", " + b.getAuthors() + ", " + b.getCategory() + ", " + b.getLanguage()
                        + ", " + b.getPublishYear());
            } else if (item instanceof Article) {
                Article a = (Article) item;
                System.out.println(", " + a.getAuthors() + ", " + a.getPublishYear());
            }
        }
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
