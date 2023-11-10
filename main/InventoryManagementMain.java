package com.sirma.InventorySystem.main;

import com.sirma.InventorySystem.FileManagement;
import com.sirma.InventorySystem.Items.InventoryItem;
import com.sirma.InventorySystem.PaymentProcessing.Order;

import java.util.Scanner;

public class InventoryManagementMain{
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        FileManagement ob = new FileManagement();
        InventoryItem in = new InventoryItem();
        ob.fillInventory();

        boolean start = true;

        while (start) {
            introduction();
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    //List of all inventory items
                    ob.createFile();
                    ob.readFromFile();
                    System.out.println();
                    System.out.println("Would you like to place an order? [Y][N]");
                    String orderInput = sc.nextLine();
                    if (orderInput.equalsIgnoreCase("Y")) {
                        menu();
                    }else if (orderInput.equalsIgnoreCase("N")){
                        start = false;
                    }
                    break;
                case "2":
                    //items categorized
                    in.category(ob.inventoryItems);
                    return;
                case "3":
                    //add new item
                    in.addItem();
                    return;
                case "4":
                    //place an order
                    ob.viewInventoryItems();
                    Order order = new Order();
                    order.fillCart(ob.inventoryItems);
                    return;
                case "5":
                    //update inventory
                    ob.removeExpired(ob.inventoryItems);
                    return;
                case "6":
                    start = false; // Exiting the loop and the program
                    break;

                default:
                    System.out.println("Invalid input. Please enter a number from 1 to 6.");
            }
        }
    } public static void introduction () {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the inventory menu; Choose a number from the list down below");
        System.out.println("1.View all inventory items");
        System.out.println("2.Display categorized items");
        System.out.println("3.Add new item");
        System.out.println("4.Place an order");
        System.out.println("5.Update inventory");
        System.out.println("6.Exit");
    }
}
