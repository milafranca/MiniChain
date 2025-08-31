package com.example.minichain.core;

import java.util.List;

public class Block {
    private int index;
    private long timestamp;
    private List<Transaction> transactions;
    private String previousHash;
    private String hash;
    private long nonce;

    public Block(int idx, String prevHash, List<Transaction> txs){
        this.index = idx;
        this.previousHash = prevHash;
        this.transactions = txs;
        this.timestamp = System.currentTimeMillis();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        StringBuilder txData = new StringBuilder();
        for(Transaction t: transactions) txData.append(t.payload());
        return CryptoUtil.sha256(index + previousHash + timestamp + txData + nonce);
    }

    public void mine(int difficulty){
        String prefix = "0".repeat(difficulty);
        while(!hash.startsWith(prefix)){
            nonce++;
            hash = calculateHash();
        }
    }

    public String getHash() { return hash; }
    public String getPreviousHash() { return previousHash; }
    public List<Transaction> getTransactions() { return transactions; }
}
