package com.example.minichain.api;

import com.example.minichain.core.Blockchain;
import com.example.minichain.core.Transaction;

public class BlockchainAPI {

    private Blockchain blockchain;

    public BlockchainAPI(Blockchain bc) {
        this.blockchain = bc;
    }

    public void sendTransaction(String from, String to, double amount, String signature) {
        Transaction tx = new Transaction(from, to, amount, signature);
        blockchain.addTransaction(tx);
        System.out.println("Transaction added: " + from + " -> " + to + " : " + amount);
    }

    public void mine(String minerAddress) {
        blockchain.minePendingTransactions(minerAddress);
        System.out.println("Block mined by: " + minerAddress);
    }

    public void getBalance(String address) {
        double balance = blockchain.getBalanceOfAddress(address);
        System.out.println("Balance of " + address + ": " + balance);
    }
}
