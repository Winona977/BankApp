/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller.utils;

/**
 *
 * @author scues
 */
public class Response {
    
    private final String message;
    private final Status status;
    private Object object;

    public Response(String message, Status status) {
        this.message = message;
        this.status = status;
    }
    
    public Response(String message, Status status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public Object getObject() {
        return object;
    }
    
}