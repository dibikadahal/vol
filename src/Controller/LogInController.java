/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.DataManager;
import Model.PasswordUtil;
import View.LogInFrame;
import javax.swing.JOptionPane;
import View.AdminDashboard;


/**
 *
 * @author ALIENWARE
 */
public class LogInController {

    private LogInFrame view;

    public LogInController(LogInFrame view) {
            this.view = view;
    }
    

    public void handleLogin(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter both username and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        User user = DataManager.getUser(username); 

        if (user == null) {
            
            String status = DataManager.getVolunteerStatus(username);
            handleVolunteerLogin(username, password, status);
            return;
        }

        if (!PasswordUtil.verifyPassword(password, user.getHashedPassword())) {
            JOptionPane.showMessageDialog(view, "Invalid username or password", "LogIn error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        openDashboard(user);
    }
    
    private void handleVolunteerLogin(String username, String password,  String status){
        if(status == null){
            JOptionPane.showMessageDialog(view, "Invalid username or password",
                    "LogIn Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        switch (status) {
            case "pending_user":
                JOptionPane.showMessageDialog(view, "Your registration is pending. \nPlease wait for the admin;s approval",
                        "Pending Approval", JOptionPane.INFORMATION_MESSAGE);
                break;
                
            case "declined_user":
                JOptionPane.showMessageDialog(view, "Ypur registration has been cancelled.\nPlease contact admin",
                        "Registration declined", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    private void openDashboard(User user){        
        JOptionPane.showMessageDialog(view,
                "Login successful! Welcome " + user.getUsername(),
                "Success", JOptionPane.INFORMATION_MESSAGE);

        if ("admin".equalsIgnoreCase(user.getRole())) {
            AdminDashboard dashboard = new AdminDashboard(user);
            dashboard.setLocationRelativeTo(null);
            dashboard.setVisible(true);
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view,
                    "User dashboard coming soon!",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
