package com.sirma.InventorySystem.Interfaces;

import com.sirma.InventorySystem.Items.InventoryItem;

import java.util.List;

public interface Item {
    public void addItem();
    public double calculatingValue(List<InventoryItem> cart);
}