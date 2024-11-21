/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.model.Account;
import core.model.Transaction;
import core.model.TransactionType;
import core.model.User;
import core.model.dataManager.AccountManager;
import core.model.dataManager.TransactionManager;
import core.model.dataManager.UserManager;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author scues
 */
public class TransactionRegister implements Registrable {
    
    private static TransactionRegister instance;
    
    private TransactionRegister() {
        
    }
    
    public static TransactionRegister getInstance() {
        if (instance == null) {
            instance = new TransactionRegister();
        }
        return instance;
    }

    @Override
    public boolean regist(String[] args) {
        try {
            switch (args[0]) {
                case "Deposit": {
                    String destinationAccountId = args[2];
                    double amount = Double.parseDouble(args[3]);

                    Account destinationAccount = null;
                    for (Account account : AccountManager.getInstance()) {
                        if (account.getId().equals(destinationAccountId)) {
                            destinationAccount = account;
                        }
                    }
                    if (destinationAccount != null) {
                        destinationAccount.deposit(amount);

                        TransactionManager.getInstance().add(new Transaction(TransactionType.DEPOSIT, null, destinationAccount, amount));
                    }
                    break;
                }
                case "Withdraw": {
                    String sourceAccountId = args[1];
                    double amount = Double.parseDouble(args[3]);

                    Account sourceAccount = null;
                    for (Account account : AccountManager.getInstance()) {
                        if (account.getId().equals(sourceAccountId)) {
                            sourceAccount = account;
                        }
                    }
                    if (sourceAccount != null && sourceAccount.withdraw(amount)) {
                        TransactionManager.getInstance().add(new Transaction(TransactionType.WITHDRAW, sourceAccount, null, amount));
                    }
                    break;
                }
                case "Transfer": {
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
                    if (sourceAccount != null && destinationAccount != null && sourceAccount.withdraw(amount)) {
                        destinationAccount.deposit(amount);

                        TransactionManager.getInstance().add(new Transaction(TransactionType.TRANSFER, sourceAccount, destinationAccount, amount));
                    }
                    break;
                }
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
}
