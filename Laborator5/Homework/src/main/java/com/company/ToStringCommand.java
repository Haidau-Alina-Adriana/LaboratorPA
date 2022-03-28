package com.company;

public class ToStringCommand extends Command {

    @Override
    public void executeCommand(Catalog catalog, String path) throws InvalidCatalogException {
        if (catalog.getItems().size() == 0) {
            throw new InvalidCatalogException("Empty catalog");
        }
        CatalogUtil.toString(catalog);
    }
}
