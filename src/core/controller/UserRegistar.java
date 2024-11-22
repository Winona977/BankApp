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
            
            UserManager.getInstance().add(new User(id, firstname, lastname, age));
            return new Response("User successfully registered", Status.CREATED);
        } catch (NumberFormatException ex) {
            return new Response("that's not a number", Status.BAD_REQUEST);
        }
    }
}
