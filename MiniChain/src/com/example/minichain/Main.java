package com.example.minichain;

import com.example.minichain.api.*;
import com.example.minichain.core.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Blockchain bc = new Blockchain();

        Wallet alice = WalletAPI.createWallet();
        Wallet bob = WalletAPI.createWallet();

        BlockchainAPI api = new BlockchainAPI(bc);

        String payload = alice.getAddress() + ":" + bob.getAddress() + ":5";
        String signature = WalletAPI.signTransaction(alice, payload);

        api.sendTransaction(alice.getAddress(), bob.getAddress(), 5, signature);
        api.mine(alice.getAddress());

        api.getBalance(alice.getAddress());
        api.getBalance(bob.getAddress());
    }
}
