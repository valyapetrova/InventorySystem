package com.sirma.InventorySystem.Interfaces;

import com.sirma.InventorySystem.Items.InventoryItem;

import java.util.List;

public interface Perishable {
    public boolean perish();
    public void removeExpired(List<InventoryItem> in);
}