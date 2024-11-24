/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.transaction;

import core.controller.utils.Response;
import core.model.Account;

/**
 *
 * @author edangulo
 */
public class Transaction {
    
    private final TransactionType type;
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final double amount;
    
    public Transaction(TransactionType type, Account sourceAccount, Account destinationAccount, double amount) {
        this.type = type;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public double getAmount() {
        return amount;
    }
    
    public Response doTransaction() {
        return type.doTransaction(this);
    }
}
