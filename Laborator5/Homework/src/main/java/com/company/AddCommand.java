package com.company;

public class AddCommand extends Command {
    private Item item;

    @Override
    public void executeCommand(Catalog catalog, String id) throws InvalidData {
        if (item == null) {
            throw new InvalidData("Load your item!");
        }
        for (int i = 0, n = catalog.getItems().size(); i < n; i++) {
            if (catalog.getItems().get(i).getId().equals(id)) {
                throw new InvalidData("An item with this id already exists!");
            }
        }
        catalog.add(item);
        System.out.println("Item " + item.getId() + " was successfully added to catalog!");
    }

    public void loadItem(Item item) {
        this.item = item;
    }
}
