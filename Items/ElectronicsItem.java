package com.sirma.InventorySystem.Items;

import com.sirma.InventorySystem.Items.InventoryItem;

import java.time.LocalDate;

public class ElectronicsItem extends InventoryItem {

    public ElectronicsItem(String name, String type, int quantity, double price, LocalDate expire, int ID) {
        super(name, type, quantity, price, expire, ID);
    }
    @Override
    public String toString() {
        return "Item: " + getName() + ", Category: " + getType() + ", Quantity: " + getQuantity() + ", Price: " + getPrice() + "$" + ", Expiry Date: " + getExpire() + " ID: " + getID();
    }
}


