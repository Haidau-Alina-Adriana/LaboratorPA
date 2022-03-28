package com.company;

import java.io.IOException;

public class SaveCommand extends Command {

    @Override
    public void executeCommand(Catalog catalog, String path) throws InvalidCatalogException, InvalidData, IOException {
        if (catalog.getItems().size() == 0) {
            throw new InvalidCatalogException("Cannot save empty catalog!");
        }
        CatalogUtil.save(catalog, path);
        System.out.println("Saved catalog!");
    }
}
