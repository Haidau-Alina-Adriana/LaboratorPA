package com.company;

import java.io.IOException;

public class ReportCommand extends Command {
    @Override
    public void executeCommand(Catalog catalog, String htmlPath) throws InvalidCatalogException, IOException {
        if (catalog.getItems().size() == 0) {
            throw new InvalidCatalogException("Empty catalog!");
        }
        CatalogUtil.report(catalog, htmlPath);
    }
}
