/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.dataManager;

import core.model.Account;
import java.util.ArrayList;

/**
 *
 * @author scues
 */
public class AccountManager extends ArrayList<Account> {
    private static AccountManager instance;
    
    private AccountManager() {
        super();
    }
    
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }
}
