package com.sirma.InventorySystem.Items;

import com.sirma.InventorySystem.Interfaces.*;
import com.sirma.InventorySystem.Items.InventoryItem;

import java.util.List;

abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    public abstract double calculatingValue(List<InventoryItem> cart);

    public abstract void category(List<InventoryItem> inventoryItems);
}