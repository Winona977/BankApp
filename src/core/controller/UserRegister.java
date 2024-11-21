/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.model.User;
import core.model.dataManager.UserManager;
import javax.swing.JOptionPane;

/**
 *
 * @author scues
 */
public class UserRegister implements Registrable {
    private static UserRegister instance;
    
    private UserRegister() {
        
    }
    
    public static UserRegister getInstance() {
        if (instance == null) {
            instance = new UserRegister();
        }
        return instance;
    }
    
    @Override
    public boolean regist(String[] args) {
        try {
            int id = Integer.parseInt(args[0]);
            String firstname = args[1];
            String lastname = args[2];
            int age = Integer.parseInt(args[3]);
            
            UserManager.getInstance().add(new User(id, firstname, lastname, age));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
