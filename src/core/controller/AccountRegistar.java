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

    public Response register(String[] args) {
        try {
            int userId = Integer.parseInt(args[0]);
            double initialBalance = Double.parseDouble(args[1]);
            
            if (initialBalance < 0){
                return new Response("Initial balance can't be negative.", Status.BAD_REQUEST);
            }

            boolean sw = true;
            User selectedUser = null;
            for (User user : UserManager.getInstance()) {
                if (user.getId() == userId) {
                    selectedUser = user;
                    sw = false;
                    break;
                }
            }
            if (sw) {
                return new Response("User does not exist.", Status.BAD_REQUEST);
            }

            if (selectedUser != null) {
                Random random = new Random();
                int first = random.nextInt(1000);
                int second = random.nextInt(1000000);
                int third = random.nextInt(100);

                String accountId = null;

                sw = false;
                int count = 0;
                do {
                    accountId = String.format("%03d", first) + "-" + String.format("%06d", second) + "-" + String.format("%02d", third);
                    for (Account account : AccountManager.getInstance()) {
                        sw = account.getId().equals(accountId);
                        if (sw) {
                            break;
                        }
                    }
                    count++;
                    if (count > 99999) {
                        return new Response("Unknown error when creating account id.", Status.INTERNAL_SERVER_ERROR);
                    }
                } while (sw);

                AccountManager.getInstance().add(new Account(accountId, selectedUser, initialBalance));
            }
            return new Response("Account successfully created.", Status.CREATED);
        } catch (NumberFormatException ex) {
            return new Response("That's not a number.", Status.BAD_REQUEST);
        }
    }

}
