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
public class TransferTransaction implements TransactionType {

    private static TransferTransaction instance;
    private static final String NAME = "Transfer";

    private TransferTransaction() {

    }

    public static TransferTransaction getInstance() {
        if (instance == null) {
            instance = new TransferTransaction();
        }
        return instance;
    }

    @Override
    public Response doTransaction(Transaction t) {
        if (t != null) {
            Account destinationAccount = t.getDestinationAccount();
            Account sourceAccount = t.getSourceAccount();
            if (destinationAccount != null & sourceAccount != null) {
                if (sourceAccount.withdraw(t.getAmount())) {
                    destinationAccount.deposit(t.getAmount());
                    TransactionManager.getInstance().add(t);
                    return new Response("Transaction completed successfully", Status.CREATED);
                }
            } else {
                return new Response("Those accounts dont exist.", Status.CREATED);
            }
        }
        return new Response("There's not enough funds", Status.BAD_REQUEST);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
