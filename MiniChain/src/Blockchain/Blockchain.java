package com.example.minichain.core;

import java.util.*;

public class Blockchain {
    private List<Block> chain = new ArrayList<>();
    private List<Transaction> pendingTransactions = new ArrayList<>();
    private int difficulty = 4;
    private double miningReward = 10;

    public Blockchain(){
        Block genesis = new Block(0,"0",List.of());
        genesis.mine(1);
        chain.add(genesis);
    }

    public void addTransaction(Transaction tx) { pendingTransactions.add(tx); }

    public Block minePendingTransactions(String minerAddress){
        Transaction reward = new Transaction(null, minerAddress, miningReward, null);
        List<Transaction> bundle = new ArrayList<>(pendingTransactions);
        bundle.add(0, reward);
        Block block = new Block(chain.size(), chain.get(chain.size()-1).getHash(), bundle);
        block.mine(difficulty);
        chain.add(block);
        pendingTransactions.clear();
        return block;
    }

    public boolean isValid(){
        for(int i=1;i<chain.size();i++){
            Block curr = chain.get(i), prev = chain.get(i-1);
            if(!curr.getHash().equals(curr.calculateHash())) return false;
            if(!curr.getPreviousHash().equals(prev.getHash())) return false;
        }
        return true;
    }

    public double getBalanceOfAddress(String address){
        double balance = 0;
        for(Block block : chain){
            for(Transaction tx : block.getTransactions()){
                if(address.equals(tx.getFromAddress())) balance -= tx.getAmount();
                if(address.equals(tx.getToAddress())) balance += tx.getAmount();
            }
        }
        return balance;
    }
}
