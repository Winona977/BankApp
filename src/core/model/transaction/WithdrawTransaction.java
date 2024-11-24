/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.transaction;

import core.controller.utils.Response;
import core.controller.utils.Status;
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
    public Response doTransaction(Transaction t) {
        if (t != null) {
            Account account = t.getSourceAccount();
            if (account != null) {
                if (account.withdraw(t.getAmount())) {
                    TransactionManager.getInstance().add(t);
                    return new Response("Transaction completed successfully", Status.CREATED);
                }
            } else {
                return new Response("That source account Doesn't exist.", Status.CREATED);
            }
        }
        return new Response("There's not enough funds", Status.BAD_REQUEST);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
