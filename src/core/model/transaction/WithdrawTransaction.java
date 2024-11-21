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
public class WithdrawTransaction implements TransactionType {
    private static WithdrawTransaction instance;
    private static final String NAME = "Withdraw";
    
    private WithdrawTransaction() {
        
    }
    
    public static WithdrawTransaction getInstance() {
        if (instance == null) {
            instance = new WithdrawTransaction();
        }
        return instance;
    }

    @Override
    public boolean doTransaction(Transaction t) {
        if (t != null) {
            Account account = t.getSourceAccount();
            if (account != null && account.withdraw(t.getAmount())) {
                TransactionManager.getInstance().add(t);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
