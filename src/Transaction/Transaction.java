package com.example.minichain.core;

public class Transaction {
    private String fromAddress;
    private String toAddress;
    private double amount;
    private String signature;

    public Transaction(String from, String to, double amount, String signature){
        this.fromAddress = from;
        this.toAddress = to;
        this.amount = amount;
        this.signature = signature;
    }

    public String payload() {
        return (fromAddress == null ? "COINBASE" : fromAddress) + ":" + toAddress + ":" + amount;
    }

    public String getFromAddress() { return fromAddress; }
    public String getToAddress() { return toAddress; }
    public double getAmount() { return amount; }
    public String getSignature() { return signature; }
}

