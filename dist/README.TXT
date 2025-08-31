# MiniChain - Simple Java Blockchain

MiniChain is a **basic blockchain implementation in Java**, built without frameworks or external libraries.  
It demonstrates fundamental blockchain concepts such as wallets, transactions, mining, and balance tracking.

## Features

- **Wallets**: Each wallet has a public/private key pair.
- **Transactions**: Signed using ECDSA.
- **Mining**: Simple Proof-of-Work with adjustable difficulty.
- **Blockchain Validation**: Ensures chain integrity.
- **Console Output**: Displays wallet creation, transactions, mining, and balances.

## Project Structure

MiniChain/
└─ src/
└─ com/example/minichain/
├─ Main.java
├─ core/
│ ├─ Block.java
│ ├─ Blockchain.java
│ ├─ CryptoUtil.java
│ ├─ Transaction.java
│ └─ Wallet.java
└─ api/
├─ BlockchainAPI.java
└─ WalletAPI.java


## How to Run

1. Open the project in **NetBeans** (or any Java IDE).
2. Make sure Java 17+ is installed.
3. Compile and run `Main.java` from `com.example.minichain`.
4. The console will display:
    - Wallets created
    - Transactions added
    - Block mined
    - Wallet balances

## Example Output

New wallet created: MFkwEwYHKoZ...
Transaction added: Alice -> Bob : 5.0
Block mined by: Alice
Balance of Alice: 5.0
Balance of Bob: 5.0
