/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.view;

import core.controller.utils.Response;
import core.controller.utils.StatusType;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author scues
 */
public class MessagePane {
    public static void showMessage(Response response, Component parentComponent) {
        int messageType;
        if (response.getStatus().getType() == StatusType.SUCCESSFUL) {
            messageType = JOptionPane.NO_OPTION;
        } else {
            messageType = JOptionPane.ERROR_MESSAGE;
        }
        JOptionPane.showMessageDialog(parentComponent, response.getMessage(), response.getStatus().getType().name(), messageType);
    }
    
    public static void showMessage(Response response) {
        showMessage(response, null);
    }
}
