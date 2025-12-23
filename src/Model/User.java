/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class User {
    private final String username;
    private final String passwordHash;
    private String role;
    
 
   // A constructor has been created to initialize a user object with all required fields
     public User(String username, String passwordHash, String role) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }
    
    
    //getter methods for accessing private fields
    public String getUsername() {
        return username;
    }
    
    public String getHashedPassword() {
        return passwordHash;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

}
