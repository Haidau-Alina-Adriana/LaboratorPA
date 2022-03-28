package com.company;

import java.io.IOException;

public class LoadCommand extends Command {

    @Override
    public void executeCommand(Catalog catalog, String path) throws IOException {
        Catalog catalog1 = CatalogUtil.load(path);
    }

    public Catalog executeCommand(String path) throws IOException {
        Catalog newCatalog = CatalogUtil.load(path);
        System.out.println("Loaded the catalog!");
        return newCatalog;
    }
}
