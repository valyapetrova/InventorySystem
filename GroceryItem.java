package com.sirma.InventorySystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class GroceryItem extends InventoryItem {

    public GroceryItem(String name, String type, int quantity, double price, LocalDate expire, int ID) {
        super(name, type, quantity, price, expire, ID);
    }
    @Override
    public String toString() {
        return "Item: " + getName() + ", Category: " + getType() + ", Quantity: " + getQuantity() + ", Price: " + getPrice() + "lv." + ", Expiry Date: " + getExpire() + " ID: " + getID();
    }
}

