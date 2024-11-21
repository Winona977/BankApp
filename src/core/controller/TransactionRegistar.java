/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.model.Account;
import core.model.transaction.Transaction;
import core.model.transaction.TransactionType;
import core.model.dataManager.AccountManager;
import core.model.dataManager.TransactionManager;
import core.model.transaction.DepositTransaction;
import core.model.transaction.TransferTransaction;
import core.model.transaction.WithdrawTransaction;

/**
 *
 * @author scues
 */
public class TransactionRegistar {

    private static TransactionRegistar instance;

    private TransactionRegistar() {

    }

    public static TransactionRegistar getInstance() {
        if (instance == null) {
            instance = new TransactionRegistar();
        }
        return instance;
    }

    public boolean register(String[] args) {
        try {
            String sourceAccountId = args[1];
            String destinationAccountId = args[2];
            double amount = Double.parseDouble(args[3]);

            Account sourceAccount = null;
            Account destinationAccount = null;
            for (Account account : AccountManager.getInstance()) {
                if (account.getId().equals(sourceAccountId)) {
                    sourceAccount = account;
                }
            }
            for (Account account : AccountManager.getInstance()) {
                if (account.getId().equals(destinationAccountId)) {
                    destinationAccount = account;
                }
            }
            TransactionType transactionType = null;
            switch (args[0]) {
                case "Deposit":
                    transactionType = DepositTransaction.getInstance();
                    break;
                case "Withdraw":
                    transactionType = WithdrawTransaction.getInstance();
                    break;
                case "Transfer":
                    transactionType = TransferTransaction.getInstance();
                    break;
            }
            new Transaction(transactionType, sourceAccount, destinationAccount, amount).doTransaction();
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
