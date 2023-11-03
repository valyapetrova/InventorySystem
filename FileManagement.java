package com.sirma.InventorySystem;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManagement extends InventoryItem {

    File file = new File("C:/Users/valya/OneDrive/inventory.txt");

    List<InventoryItem> inventoryItems = new ArrayList<>();

    public FileManagement(String name, String type, int quantity, double price, LocalDate expire, int ID) {
        super(name, type, quantity, price, expire, ID);
    }

    public FileManagement() {
        super();
    }


    public void fillInventory() {
        inventoryItems.add(new ElectronicsItem("iPhone 13", "electronic", 5, 990.99, null, 1));
        inventoryItems.add(new ElectronicsItem("Dell XPS 15", "electronic", 10, 1500.50, null, 2));
        inventoryItems.add(new ElectronicsItem("Samsung QLED TV", "electronic", 3, 800, null, 3));
        inventoryItems.add(new ElectronicsItem("Sony WH-1000XM4", "electronic", 15, 249.99, null, 4));
        inventoryItems.add(new GroceryItem("Apples", "grocery", 10, 2.49, LocalDate.parse("2023-10-25"), 5));
        inventoryItems.add(new GroceryItem("Canned Soup", "grocery", 20, 1.99, LocalDate.parse("2024-05-15"),6));
        inventoryItems.add(new GroceryItem("Milk", "grocery", 6, 2.79, LocalDate.parse("2023-11-30"),7));
        inventoryItems.add(new GroceryItem("Wheat Bread", "grocery", 8, 2.29, LocalDate.parse("2023-10-28"),8));
        inventoryItems.add(new FragileItem("Crystal Vase", "fragile", 1, 79.99, null, 8.70,9));
        inventoryItems.add(new FragileItem("Glass Ornament", "fragile", 3, 9.99, null, 3.20,10));
        inventoryItems.add(new GroceryItem("Apples", "grocery", 10, 2.49, LocalDate.parse("2023-10-25"), 5));

        if(isBreakable()){
            FragileItem fr = new FragileItem();
            fr.increasePriceIfBreakable(inventoryItems);
        }
        isBreakable();
    }

    public void readFromFile(){
        if(file.exists()){
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                in.read();
                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }}
        else {
            System.out.println("File does not exist");
        }

    }
    public void writeToFile(){
        try{ ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(inventoryItems);

        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    public void viewInventoryItems() {
        for (InventoryItem in : inventoryItems){
            System.out.println(in);
        }
    }

}