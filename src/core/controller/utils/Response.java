/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller.utils;

/**
 *
 * @author scues
 * @param <T>
 */
public class Response<T> {
    
    private final String message;
    private final Status status;
    private T object;

    public Response(String message, Status status) {
        this.message = message;
        this.status = status;
    }
    
    public Response(String message, Status status, T object) {
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

    public T getObject() {
        return object;
    }
    
}