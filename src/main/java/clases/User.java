/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Rafa
 */
public class User {
    private String email;
    private String name;
    private String pass;
    private String role;
    
    
    public User(String email, String name, String pass, String role) {
        this.email = email;
        this.name = name;
        this.pass = pass;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }
    
    
}
