/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.controller.utils.Response;
import core.controller.utils.Status;
import core.model.User;
import core.model.dataManager.UserManager;

/**
 *
 * @author scues
 */
public class UserRegistar {

    private static UserRegistar instance;

    private UserRegistar() {

    }

    public static UserRegistar getInstance() {
        if (instance == null) {
            instance = new UserRegistar();
        }
        return instance;
    }

    public Response register(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            String firstname = args[1];
            String lastname = args[2];
            int age = Integer.parseInt(args[3]);

            for (User user : UserManager.getInstance()) {
                if (id == user.getId()){
                    return new Response("Id number already exists.", Status.BAD_REQUEST);
                }
            }

            if (id >= 999999999 || id < 0) {
                return new Response("Id number out of limit.", Status.BAD_REQUEST);
            }

            if (age < 18) {
                return new Response("Underage users can not register.", Status.BAD_REQUEST);
            }
            if (firstname == null) {
                return new Response("First name can't be empty.", Status.BAD_REQUEST);
            }
            if (lastname == null) {
                return new Response("Last name can't be empty..", Status.BAD_REQUEST);
            }

            UserManager.getInstance().add(new User(id, firstname, lastname, age));
            return new Response("User successfully registered", Status.CREATED);
        } catch (NumberFormatException ex) {
            return new Response("that's not a number", Status.BAD_REQUEST);
        }
    }
}
