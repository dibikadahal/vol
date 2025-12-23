/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 *Centralized validations
 */
public class ValidationUtil {
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile ("^[0-9]{10}$");
    private static final Pattern NAME_PATTERN = Pattern.compile ("^[a-zA-Z\\s]+$");
    
    //VALIDATE FULL NAME
    public static String validateFullName(String name){
        if (name == null || name.trim().isEmpty()){
            return "Full name is required";
        }
        if (!NAME_PATTERN.matcher(name).matches()){
            return "Only letters and spaces allowed";
        }
        return null;
    }
    
    
    //VALIDATE DATE OF BIRTH
    public static String validateDOB(String dob){
        if (dob == null || dob.trim().isEmpty() || dob.equals("yyyy/mm/dd")){
            return "Date of birth is required";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        
        try{
            Date birthDate = sdf.parse(dob);
            Date currentDate = new Date();
            
            if(birthDate.after(currentDate)){
                return "Date cannot be in the future";
            }
            
            long ageInYears = (currentDate.getTime() - birthDate.getTime()) / (1000L * 60 * 60 *24 *365);
            
            if (ageInYears < 13){
                return "Must be at least 13 years old";
            }
            if (ageInYears > 120){
                return "Please enter a valid date";
            }
            return null;
            
        }catch (ParseException e){
            return "Invalid date format (use u=yyyy/mm/dd)";
        }
    }
    
    
    //VALIDATE CONTACT NUMBER
    public static String validateContact (String contact){
        if (contact == null || contact.trim().isEmpty()){
            return " Contact num,ber is required.";
        }
        if(!PHONE_PATTERN.matcher(contact).matches()){
            return "Enter valid phone number (10 digits)";
        }
        return null;
    }
    
    
    
    //VALIDATE EMAIL
    public static String validateEmail(String email){
        if (email == null || email.trim().isEmpty()){
            return "Email is required";
        }
        if (!EMAIL_PATTERN.matcher(email).matches()){
            return "Enter valid email address";
        }
        return null;
    }
    
    
    //VALIDATE EDUCATION
    public static String validateEducation(String education){
        if (education == null || education.trim().isEmpty()){
            return "Education is required";
        }
        return null;
    }
    
    
    //VALIDATE SKILLSS
    public static String validateSkills(String skills){
        if(skills == null || skills.trim().isEmpty()){
            return "Skills are required";
        }
        return null;
    }
    
    
    //VALIDATE EXPERIENCE
    public static String validateExperience(String experience){
        if(experience == null || experience.trim().isEmpty() ){
            return "Past experience is required";
        }
        return null;                
    }
    
    
    //VALIDATE USERNAME
    public static String validateUsername(String username){
        if (username == null || username.trim().isEmpty()){
            return "Username is required";
        }
        if (DataManager.usernameExists(username)){
            return "Username already exists";
        }
        return null;
    }
    
    
    //VALIDATE PASSWORD
    public static String validatePassword(String password){
        if (password == null || password.isEmpty()){
            return "Password is required";
        }
        if(password.length() < 6){
            return "Password must be at least 6 characters";
        }
        return null;
    }
    
}
