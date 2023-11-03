package com.sirma.InventorySystem;

import java.util.List;

public interface Perishable {
    public boolean perish();
    public void removeExpired(List<InventoryItem> in);
}