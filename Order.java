package com.sirma.InventorySystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order extends InventoryItem {
    private ArrayList<InventoryItem> cart = new ArrayList<>();

    public void fillCart(List<InventoryItem> inventoryItems) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of item: ");
        String input = sc.nextLine(); // Store user input

        while (!input.equals("order")) {
            int id = Integer.parseInt(input);

            for (InventoryItem item : inventoryItems) {
                if (id == item.getID()) {
                    cart.add(item);
                    System.out.println("Item added to cart successfully!");
                    break;
                }
            }
            input = sc.nextLine();
        }
        System.out.println("Items in Cart:");
        for (InventoryItem cartItem : cart) {
            System.out.println(cartItem);
        } getTotalPrice(cart);
        System.out.println("How would you like to pay?: (only credit cards available at the moment!)");
        System.out.println("Please enter your details!");
        makeOrder();
    }

    public void makeOrder(){
        CreditCardPayment cr = new CreditCardPayment();
        cr.payCreditCard(cart);
    }

    private void calculatingValue(ArrayList<InventoryItem> cart) {
    }
}
