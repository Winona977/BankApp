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
public class UserManagerController {
    private static UserManagerController instance;

    private UserManagerController() {

    }

    public static UserManagerController getInstance() {
        if (instance == null) {
            instance = new UserManagerController();
        }
        return instance;
    }
    
    public Response<User[]> list() {
        UserManager users = UserManager.getInstance();
        User[] result = new User[users.size()];
        if (users.isEmpty()) {
            return new Response("There's no Users", Status.NO_CONTENT, result);
        }
        
        users.sort((obj1, obj2) -> (obj1.getId() - obj2.getId()));
        
        return new Response("Users listed successfully", Status.OK, users.toArray(result));
    }
}
