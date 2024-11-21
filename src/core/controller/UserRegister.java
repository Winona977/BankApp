/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller;

import core.model.User;
import core.model.UserManager;
import javax.swing.JOptionPane;

/**
 *
 * @author scues
 */
public class UserRegister {
    private static UserRegister instance;
    
    private UserRegister() {
        
    }
    
    public static UserRegister getInstance() {
        if (instance == null) {
            instance = new UserRegister();
        }
        return instance;
    }
    
    public void Regist(String id, String firstname, String lastname, String age) {
        try {
            int idInt = Integer.parseInt(id);
            int ageInt = Integer.parseInt(age);
            
            UserManager.getInstance().add(new User(idInt, firstname, lastname, ageInt));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
