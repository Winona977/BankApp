/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.controller.utils.Response;
import core.controller.utils.Status;
import core.model.User;
import core.model.dataManager.TransactionManager;
import core.model.dataManager.UserManager;
import core.model.transaction.Transaction;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author scues
 */
public class TransactionManagerController {
    private static TransactionManagerController instance;

    private TransactionManagerController() {

    }

    public static TransactionManagerController getInstance() {
        if (instance == null) {
            instance = new TransactionManagerController();
        }
        return instance;
    }
    
    public Response<Transaction[]> list() {
        TransactionManager transactions = TransactionManager.getInstance();
        Transaction[] result = new Transaction[transactions.size()];
        if (transactions.isEmpty()) {
            return new Response("There's no Transactions", Status.NO_CONTENT, result);
        }
        
        ArrayList<Transaction> transactionsCopy = (ArrayList<Transaction>) transactions.clone();
        Collections.reverse(transactionsCopy);
        
        return new Response("Transactions listed successfully", Status.OK, transactionsCopy.toArray(result));
    }
}
