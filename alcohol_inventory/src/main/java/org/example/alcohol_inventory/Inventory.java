package org.example.alcohol_inventory;

import java.util.Collection;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Alcohol> inventory = new HashMap<>();

    public void addItem(Alcohol item) {
        inventory.put(item.getId(), item);
    }

    public Alcohol getItem(String id) {
        return inventory.get(id);
    }

    public void removeItem(String id) {
        inventory.remove(id);
    }

    public void updateQuantity(String id, int quantity) {
        Alcohol item = inventory.get(id);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    public Collection<Alcohol> getAllItems() {
        return inventory.values();
    }

    public boolean idExists(String id) {
        return inventory.containsKey(id);
    }
}