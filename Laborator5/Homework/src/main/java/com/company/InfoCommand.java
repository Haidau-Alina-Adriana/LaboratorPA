package com.company;

import org.apache.commons.validator.routines.UrlValidator;

public class InfoCommand extends Command {
    @Override
    public void executeCommand(Catalog catalog, String path) throws InvalidCatalogException {
        if (catalog.getItems().size() == 0) {
            throw new InvalidCatalogException("Empty catalog");
        }
        for (Item item : catalog.getItems()) {
            UrlValidator url = new UrlValidator();
            if (url.isValid(item.getLocation())) {
                System.out.print("\nItem with id " + item.getId() + " is a web reference.\n");
            } else {
                CatalogUtil.getMetadata(item.getLocation());
            }
        }
    }
}
