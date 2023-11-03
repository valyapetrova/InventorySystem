package com.sirma.InventorySystem;
import java.time.LocalDate;
import java.util.List;


public class FragileItem extends InventoryItem {
    private double weight;
    public FragileItem(String name, String type, int quantity, double price, LocalDate expire, double weight, int ID) {
        super(name, type, quantity, price, expire, ID);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    //fragile items have insurance
    public void increasePriceIfBreakable(List<InventoryItem> inventoryItems) {
        for (InventoryItem in : inventoryItems){
            if (getType().equals("fragile")) {
                setPrice(getPrice() + (0.1 * weight));
            }
        }
    }
    public FragileItem() {}
    @Override
    public String toString() {
        return "Item: " + getName() + ", Category: " + getType() + ", Quantity: " + getQuantity() + ", Price: " + getPrice() + "lv." + ", Expiry Date: " + getExpire() + " ID: " + getID();
    }

}
