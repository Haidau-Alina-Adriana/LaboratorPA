package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog  implements Serializable {
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

    public Catalog load(String path) throws IOException{
        Catalog catalog = new ObjectMapper().readValue(new File(path), Catalog.class);
        return catalog;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
