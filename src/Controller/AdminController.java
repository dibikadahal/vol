/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Volunteer;
import Model.DataManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AdminController {
 private JFrame view;
 
 public AdminController(JFrame view){
     this.view = view;
 }
 
 
 //======APPROVE VOLUNTEERS==========
 public boolean approveVolunteer (Volunteer volunteer, int rowIndex){
     if (rowIndex != 0){
         Volunteer first = DataManager.front();
         JOptionPane.showMessageDialog (view, "Please process volunteers in order!\n\n" +
                 "Queue rule : First volunteer must be proceeded first\n\n" +
                 "First in queue: " +  first.getFullName() + "\n" +
                 " (Registered: " + first.getRegistrationDateTime() + ")",
                 "Queue order Required", JOptionPane.WARNING_MESSAGE);
         return false;
     }
        int confirm = JOptionPane.showConfirmDialog(view,
                "Accept volunteer: " + volunteer.getFullName() + "?\n\n"
                + "Registration Date: " + volunteer.getRegistrationDateTime() + "\n"
                + "Email: " + volunteer.getEmail() + "\n\n"
                + "This will grant them system access.",
                "Confirm Accept", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (DataManager.approveVolunteer(volunteer.getUsername())) {
                JOptionPane.showMessageDialog(view,
                        "✓ " + volunteer.getFullName() + " APPROVED!\n\n"
                        + "They can now login.\nUsername: " + volunteer.getUsername(),
                        "Volunteer Approved", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }
 
 
 //================DECLINE VOLUNTEERS================
    public boolean declineVolunteer(Volunteer volunteer, int rowIndex) {
        if (rowIndex != 0) {
            Volunteer first = DataManager.front();
            JOptionPane.showMessageDialog(view,
                    "⚠ Please process volunteers in order!\n\n"
                    + "First in queue: " + first.getFullName(),
                    "Queue Order Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String reason = JOptionPane.showInputDialog(view,
                "Decline " + volunteer.getFullName() + "\n\n"
                + "Optional: Enter reason (or leave blank):",
                "Confirm Decline", JOptionPane.WARNING_MESSAGE);

        if (reason == null) {
            return false;
        }

        int confirm = JOptionPane.showConfirmDialog(view,
                "Are you sure you want to DECLINE?\n\n"
                + "Volunteer: " + volunteer.getFullName() + "\n"
                + "They will NOT be able to access the system.",
                "Final Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (DataManager.declineVolunteer(volunteer.getUsername())) {
                JOptionPane.showMessageDialog(view,
                        "✗ " + volunteer.getFullName() + " DECLINED.",
                        "Volunteer Declined", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }
 }

