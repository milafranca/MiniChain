package com.example.minichain.core;

import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Wallet {
    private final KeyPair keyPair;

    public Wallet() { keyPair = CryptoUtil.generateECKeyPair(); }

    public String getAddress() { return CryptoUtil.publicKeyToBase64(keyPair.getPublic()); }

    public String signPayload(String payload) throws Exception {
        return CryptoUtil.sign(keyPair.getPrivate(), payload);
    }

    public static boolean verify(String base64PubKey, String payload, String signature) {
        try {
            byte[] bytes = Base64.getDecoder().decode(base64PubKey);
            KeyFactory kf = KeyFactory.getInstance("EC");
            PublicKey pub = kf.generatePublic(new X509EncodedKeySpec(bytes));
            return CryptoUtil.verify(pub, payload, signature);
        } catch(Exception e) { return false; }
    }
}
