/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.model.Account;
import core.model.User;
import core.model.dataManager.AccountManager;
import core.model.dataManager.UserManager;
import java.util.Random;

/**
 *
 * @author scues
 */
public class AccountRegistar {
    
    private static AccountRegistar instance;
    
    private AccountRegistar() {
        
    }
    
    public static AccountRegistar getInstance() {
        if (instance == null) {
            instance = new AccountRegistar();
        }
        return instance;
    }

    public boolean register(String[] args) {
        try {
            int userId = Integer.parseInt(args[0]);
            double initialBalance = Double.parseDouble(args[1]);

            User selectedUser = null;
            for (User user : UserManager.getInstance()) {
                if (user.getId() == userId && selectedUser == null) {
                    selectedUser = user;
                }
            }

            if (selectedUser != null) {
                Random random = new Random();
                int first = random.nextInt(1000);
                int second = random.nextInt(1000000);
                int third = random.nextInt(100);

                String accountId = String.format("%03d", first) + "-" + String.format("%06d", second) + "-" + String.format("%02d", third);

                AccountManager.getInstance().add(new Account(accountId, selectedUser, initialBalance));
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
}
