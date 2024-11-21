/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.dataManager;

import core.model.Transaction;
import java.util.ArrayList;

/**
 *
 * @author scues
 */
public class TransactionManager extends ArrayList<Transaction> {
    private static TransactionManager instance;
    
    private TransactionManager() {
        super();
    }
    
    public static TransactionManager getInstance() {
        if (instance == null) {
            instance = new TransactionManager();
        }
        return instance;
    }
}
