package com.company;

import java.io.IOException;

public abstract class Command {
    public abstract void executeCommand(Catalog catalog, String pathOrId)
            throws InvalidCatalogException, InvalidData, IOException, ClassNotFoundException;
}
