package com.sirma.InventorySystem.Interfaces;

import com.sirma.InventorySystem.Items.InventoryItem;

import java.util.List;

public interface Categorizable {
    public void category(List<InventoryItem> inventoryItems);
}
