package com.sirma.InventorySystem;

import java.util.List;

public interface Item {
    public void addItem();
    public void itemDetails();
    public double calculatingValue(List<InventoryItem> cart);
    public void itemDiscription();
}