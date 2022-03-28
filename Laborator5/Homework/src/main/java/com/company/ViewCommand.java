package com.company;

import java.io.IOException;

public class ViewCommand extends Command {
    @Override
    public void executeCommand(Catalog catalog, String id) throws InvalidCatalogException, InvalidData, IOException {
        if (catalog.getItems().size() == 0) {
            throw new InvalidCatalogException("Empty catalog!");
        }
        if (catalog.findById(id) == null) {
            throw new InvalidData("Couldn't find the item in catalog!");
        }
        CatalogUtil.view(catalog, catalog.findById(id));
    }
}
