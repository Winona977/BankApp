/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class User {
    
    private final int id;
    private final String firstname;
    private final String lastname;
    private final int age;
    private final ArrayList<Account> accounts;

    public User(int id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
    
    public int getNumAccounts() {
        return this.accounts.size();
    }
    
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    
}
