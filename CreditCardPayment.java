package com.sirma.InventorySystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardPayment extends PaymentProcessor {
    private ArrayList<CreditCardPayment> payments = new ArrayList<>();
    public CreditCardPayment(String name, String cardNumber, int pin, double balance) {
        super(name, cardNumber, pin, balance);
    }

    public CreditCardPayment() {

    }

    public void payCreditCard(List<InventoryItem> cart){
        Scanner sc = new Scanner(System.in);
        System.out.println("Card holder name: ");
        String name = sc.nextLine();
        System.out.println("Enter card number: ");
        String cardNumber = sc.nextLine();
        regexValidation(cardNumber);
        System.out.println("Enter pin: ");
        int pin = Integer.parseInt(sc.nextLine());
        System.out.println("Balance of card: ");
        double balance = Double.parseDouble(sc.nextLine());
        CreditCardPayment payment = new CreditCardPayment(name, cardNumber, pin,balance);
        //payments.add(payment); //storing information for further use
        InventoryItem tb = new InventoryItem();
        double totalPrice = tb.calculatingValue(cart); // Pass the cart for calculation
        if (balance < totalPrice) {
            System.out.println("Not enough money in card");
        } else if (balance >= totalPrice) {
            balance -= totalPrice; // Deduct the total price from the balance
            System.out.printf("Remaining balance: %.2f ", balance);
        }
    }
    public boolean regexValidation(String cardNumber) {
        Pattern pattern = Pattern.compile("^(4[0-9]{12}(?:[0-9]{3})?$)|(^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$)|(3[47][0-9]{13})|(^3(?:0[0-5]|[68][0-9])[0-9]{11}$)|(^6(?:011|5[0-9]{2})[0-9]{12}$)|(^(?:2131|1800|35\\d{3})\\d{11}$)");
        Matcher matcher = pattern.matcher(cardNumber);
        if(!matcher.find()){
            System.out.println("wrong number format");
        }
        return matcher.find();
    }
}