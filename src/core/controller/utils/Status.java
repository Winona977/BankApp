/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controller.utils;

/**
 *
 * @author scues
 */
public class Status {
    private final int number;
    private final StatusType type;

    public Status(int number, StatusType type) {
        this.number = number;
        this.type = type;
    }
    
    // Successful response
    public static final Status OK = new Status(200, StatusType.SUCCESSFUL);
    public static final Status CREATED = new Status(201, StatusType.SUCCESSFUL);
    public static final Status NO_CONTENT = new Status(204, StatusType.SUCCESSFUL);
    
    // Client error response
    public static final Status BAD_REQUEST = new Status(400, StatusType.CLIENT_ERROR);
    public static final Status NOT_FOUND = new Status(404, StatusType.CLIENT_ERROR);
    
    // Server error response
    public static final Status INTERNAL_SERVER_ERROR = new Status(500, StatusType.SERVER_ERROR);
    public static final Status NOT_IMPLEMENTED = new Status(501, StatusType.SERVER_ERROR);

    public int getNumber() {
        return number;
    }

    public StatusType getType() {
        return type;
    }
}