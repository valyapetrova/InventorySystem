package com.sirma.InventorySystem;

import java.util.List;

abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable{
    public abstract double calculatingValue(List<InventoryItem> cart);

    public abstract void category(List<InventoryItem> inventoryItems);
}