package com.sirma.InventorySystem;

import java.io.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

public class InventoryItem extends AbstractItem implements Serializable {

    private String name;
    private int ID;
    private String type;
    private int quantity;
    private double price;
    private LocalDate expire;
    double totalPrice = 0;


    public InventoryItem(String name, String type, int quantity, double price, LocalDate expire, int ID) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.expire = expire;
        this.ID = ID;
    }

    public InventoryItem() {

    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean isBreakable() {
        if (getType() != null) {
            if (getType().equals("fragile") && getType() != null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    @Override
    public void addItem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter item name:");
        String itemName = sc.nextLine();
        System.out.println("Enter category: (fragile,inventory,grocery)");
        String type = sc.nextLine();
        System.out.println("Enter quantity:");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter date of expire: (YYYY-MM-DD or type 'null' if the item doesn't expire)");
        String dateInput = sc.nextLine();
        LocalDate date = null;
        if (!dateInput.equalsIgnoreCase("null")) {
            date = LocalDate.parse(dateInput);
        }
        System.out.println("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());

        InventoryItem item = new InventoryItem(itemName, type, quantity, price, date, id);
        FileManagement fm = new FileManagement();
        if (item != null) {
            fm.inventoryItems.add(item);
            for (InventoryItem im : fm.inventoryItems) {
                System.out.println(im);
            }
        } else {
            System.out.println("Item type doesn't match category or is not recognized.");
        }
    }

    @Override
    public void itemDetails() {
    }

    @Override
    public double calculatingValue(List<InventoryItem> cart) {
        double totalPrice = 0.0;

        if (canBeSold()) {
            for (InventoryItem item : cart) {
                totalPrice += item.getPrice();
            }
        }
        return totalPrice; // Return the updated total price
    }

    public void getTotalPrice(List<InventoryItem> cart) {
        if (canBeSold()) {
            for (InventoryItem item : cart) {
                totalPrice += item.getPrice();

            }System.out.printf("Total Price: %.2f lv.%n", totalPrice);
        }}

    @Override
    public void itemDiscription() {}

    @Override
    public boolean perish() {
        if (getExpire() != null) {
            return true;
        }
        return false;
    }

    @Override
    public void removeExpired(List<InventoryItem> in) {
        if (perish()) {
            ChronoLocalDate currentDate = LocalDate.from(ZonedDateTime.now());
            for(InventoryItem item : in){
                if (getExpire().isEqual(currentDate) || getExpire().isBefore(currentDate)) {
                    System.out.println("Expired item");
                    in.remove(item);
                }}
            for (InventoryItem item : in){
                System.out.println(item);
            }
        }
    }

    @Override
    public boolean canBeSold() {
        if (getPrice() != 0 || perish() == true) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public void category(List<InventoryItem> inventoryItems) {
        System.out.println("Fragile items:");
        for (InventoryItem fr : inventoryItems) {
            if (fr.getType().equals("fragile")) {
                System.out.println(fr);
            }
        }
        System.out.println("Electronic items:");
        for (InventoryItem el : inventoryItems) {
            if (el.getType().equals("electronic")) {
                System.out.println(el);
            }
        }
        System.out.println("Grocery items:");
        for (InventoryItem gr : inventoryItems) {
            if (gr.getType().equals("grocery")) {
                System.out.println(gr);
            }
        }
    }
    @Override
    public String toString() {
        return "Item: " + name + ", Category: " + type + ", Quantity: " + quantity + ", Price: " + price + "lv." + ", Expiry Date: " + expire + " ID: " + ID;
    }
}