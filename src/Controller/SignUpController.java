/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Volunteer;
import Model.DataManager;
import Model.PasswordUtil;
import Model.ValidationUtil;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 *
 * @author ALIENWARE
 */
public class SignUpController{
    
    private JPanel view;
    
   public SignUpController (JPanel view) {
       this.view = view;
   }
   
   
   public boolean handleSignUp(String fullName, String dob, String gender, String contact, String email,
           String education, String skills, String experience, String username, String password){
       
       
       //validate
       String error = validateAll (fullName, dob, gender, contact, email, education, skills, experience, username, password);
       
       
       if (error != null){
           JOptionPane.showMessageDialog(view, error, "Validation Error", JOptionPane.ERROR_MESSAGE);
           return false;
       }
       
       //check if the queue is full before creating volunteers
       if (DataManager.isQueueFull()){
           JOptionPane.showMessageDialog(view, 
                   "Registeration Queue is Full!\n\n" +
                           "We cannot accept new registration at this time.\n" + 
                           "Please try again again later.\n\n" +
                           "Current queue: " + DataManager.getQueueSize() + "/" + DataManager.getQueueSize(),
                   "Queue Full",
                   JOptionPane.WARNING_MESSAGE);
           return false;
       }
       
       //Hash password
       String hashedPassword = PasswordUtil.hash(password);
       
       //Create volunteer
       Volunteer volunteer = new Volunteer(
       fullName.trim(), dob.trim(), gender, contact.trim(), email.trim(), education.trim(), skills.trim(), experience.trim(), username.trim(), hashedPassword, "user");
       
       
       //Register (enqueue)
        if (DataManager.registerVolunteer(volunteer)) {
            JOptionPane.showMessageDialog(view,
                    "Registration Successful!\n\n"
                    + "Your application has been submitted.\n"
                    + "Please wait for admin approval.\n\n"
                    + "You will be notified once your registration is reviewed.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(view,
                    "Registration Failed!\n\n"
                    + "Username may already exist or queue is full.\n"
                    + "Please try again with a different username.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
   }
   
   private String validateAll(String fullName, String dob, String gender, String contact, String email, 
           String education, String skills, String experience, String username, String password ){
       
       String error;
       if ((error = ValidationUtil.validateFullName(fullName)) != null) return error;
       if ((error = ValidationUtil.validateDOB(dob)) != null) return error;
        if ("Gender".equals(gender)) return "Please select a gender";
        if ((error = ValidationUtil.validateContact(contact)) != null) return error;
        if ((error = ValidationUtil.validateEmail(email)) != null) return error;
        if ((error = ValidationUtil.validateEducation(education)) != null) return error;
        if ((error = ValidationUtil.validateSkills(skills)) != null) return error;
        if ((error = ValidationUtil.validateExperience(experience)) != null) return error;
        if ((error = ValidationUtil.validateUsername(username)) != null) return error;
        if ((error = ValidationUtil.validatePassword(password)) != null) return error;

        return null;
   }   
}
