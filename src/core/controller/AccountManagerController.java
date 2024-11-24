/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.controller.utils.Response;
import core.controller.utils.Status;
import core.model.Account;
import core.model.User;
import core.model.dataManager.AccountManager;
import core.model.dataManager.UserManager;

/**
 *
 * @author scues
 */
public class AccountManagerController {
    private static AccountManagerController instance;

    private AccountManagerController() {

    }

    public static AccountManagerController getInstance() {
        if (instance == null) {
            instance = new AccountManagerController();
        }
        return instance;
    }
    
    public Response<Account[]> list() {
        AccountManager accounts = AccountManager.getInstance();
        accounts.sort((obj1, obj2) -> (obj1.getId().compareTo(obj2.getId())));
        Account[] result = new Account[accounts.size()];
        return new Response("Users listed successfully", Status.OK, accounts.toArray(result));
    }
}
