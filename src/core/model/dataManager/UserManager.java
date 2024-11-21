/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.dataManager;

import core.model.User;
import java.util.ArrayList;

/**
 *
 * @author scues
 */
public class UserManager extends ArrayList<User> {
    private static UserManager instance;
    
    private UserManager() {
        super();
    }
    
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
