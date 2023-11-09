package com.sirma.InventorySystem.PaymentProcessing;

public class PaymentProcessor {
    private String name;
    private String cardNumber;
    private int pin;
    private double balance;

    public PaymentProcessor(String name, String cardNumber, int pin, double balance){
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public PaymentProcessor() {
    }
}