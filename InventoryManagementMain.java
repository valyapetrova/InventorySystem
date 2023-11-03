package com.sirma.InventorySystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class InventoryManagementMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileManagement ob = new FileManagement();
        ob.fillInventory();
        introduction();
        String input = sc.nextLine();

        if(input.equals("1")){
            //List of all inventory items
            // ob.writeToFile();    //already have the items in the file so i dont need
            ob.readFromFile();                  //the function to write them second time

            ob.viewInventoryItems();
            System.out.println();
            System.out.println("Would you like to place an order? [Y][N]");
            if(sc.nextLine().equals("Y")){
                System.out.println("choose 4 from the menu");
                introduction();
                input = sc.nextLine();
            }
        }
        if(input.equals("2")){
            //items categorized
            InventoryItem in = new InventoryItem();
            in.category(ob.inventoryItems);

        }
        if(input.equals("3")){
            //add new item
            InventoryItem in = new InventoryItem();
            in.addItem();
        }
        if(input.equals("4")){
            //place an order
            ob.viewInventoryItems();
            Order order = new Order();
            order.fillCart(ob.inventoryItems);

        }
        if(input.equals("5")){
            //update inventory
            ob.removeExpired(ob.inventoryItems);
        }
    }
    public static void introduction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("This is the inventory menu; Choose a number from the list down below");
        System.out.println("1.View all inventory items");
        System.out.println("2.Display categorized items");
        System.out.println("3.Add new item");
        System.out.println("4.Place an order");
        System.out.println("5.Update inventory");
    }
}