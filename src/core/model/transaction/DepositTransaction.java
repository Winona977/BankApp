/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.transaction;

import core.model.Account;
import core.model.dataManager.TransactionManager;

/**
 *
 * @author scues
 */
public class DepositTransaction implements TransactionType {

    private static DepositTransaction instance;
    private static final String NAME = "Deposit";

    private DepositTransaction() {

    }

    public static DepositTransaction getInstance() {
        if (instance == null) {
            instance = new DepositTransaction();
        }
        return instance;
    }

    @Override
    public boolean doTransaction(Transaction t) {
        if (t != null) {
            Account account = t.getDestinationAccount();
            if (account != null) {
                account.deposit(t.getAmount());
                TransactionManager.getInstance().add(t);
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
