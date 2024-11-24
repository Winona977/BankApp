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
        users.sort((obj1, obj2) -> (obj1.getId() - obj2.getId()));
        User[] result = new User[users.size()];
        return new Response("Users listed successfully", Status.OK, users.toArray(result));
    }
}
