package com.example.minichain.api;

import com.example.minichain.core.Wallet;

public class WalletAPI {

    public static Wallet createWallet() {
        Wallet w = new Wallet();
        System.out.println("New wallet created: " + w.getAddress());
        return w;
    }

    public static String signTransaction(Wallet wallet, String payload) throws Exception {
        return wallet.signPayload(payload);
    }
}
