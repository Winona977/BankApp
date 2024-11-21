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
import javax.swing.JOptionPane;

/**
 *
 * @author scues
 */
public class AccountRegister implements Registrable {
    
    private static AccountRegister instance;
    
    private AccountRegister() {
        
    }
    
    public static AccountRegister getInstance() {
        if (instance == null) {
            instance = new AccountRegister();
        }
        return instance;
    }

    @Override
    public boolean regist(String[] args) {
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
