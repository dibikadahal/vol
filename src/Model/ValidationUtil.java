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
    
    
    //VALIDATE SKILLS
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
    
    //VALIDATE EVENT NAME
    public static String validateEventName(String eventName){
        if (eventName == null || eventName.trim().isEmpty()){
            return "Event name is required";
        }
        if (eventName.trim().length()<3){
            return "Event name must be at least 3 characters";
        }
        return null;
    }
    
    
    //VALIDATE DESCRIPTION
        public static String validateDescription(String description){
        if (description == null || description.trim().isEmpty()){
            return "Description is required";
        }
        if (description.trim().length() < 10){
            return "Description must be at least 10 characters";
        }
        return null;
    }

     //VALIDATE EVENT DATE (accepts yyyy-MM-dd or yyyy/MM/dd)
    public static String validateEventDate(String dateStr){
        if (dateStr == null || dateStr.trim().isEmpty()){
            return "Date is required";
        }
        
        SimpleDateFormat[] formats = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd")
        };
        
        for (SimpleDateFormat format : formats) {
            format.setLenient(false);
            try {
                format.parse(dateStr.trim());
                return null; // Valid date
            } catch (ParseException e) {
                // Try next format
            }
        }
        return "Invalid date format (use yyyy-MM-dd)";
    }
    
    
    //VALIDATE END DATE IS AFTER THE START DATE
    public static String validateDateRange(String startDateStr, String endDateStr){
        //check if both dates are valid
                String startValidation = validateEventDate(startDateStr);
        if (startValidation != null) {
            return startValidation;
        }
        
        String endValidation = validateEventDate(endDateStr);
        if (endValidation != null) {
            return endValidation;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // Replace forward slashes with hyphens for consistent parsing
            String startStr = startDateStr.replace("/", "-");
            String endStr = endDateStr.replace("/", "-");

            Date startDate = format.parse(startStr);
            Date endDate = format.parse(endStr);

            if (endDate.before(startDate)) {
                return "End date must be after or equal to start date";
            }
            return null; // Valid date range

        } catch (ParseException e) {
            return "Invalid date format";
        }
    }
        
        
        //VALIDATE LOCATION
        public static String validateLocation(String location){
        if (location == null || location.trim().isEmpty()){
            return "Location is required";
        }
        return null;
    }
        
     //VALIDATE EVENT STATUS
    public static String validateEventStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            return "Event status is required";
        }
        return null;
    }
    
    //VALIDATE ORGANIZER NAME
    public static String validateOrganizerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Organizer name is required";
        }
        if (!NAME_PATTERN.matcher(name).matches()) {
            return "Name should contain only letters";
        }
        return null;
    }
    
    
    //VALIDATE ORGANIZER CONTACT
    public static String validateOrganizerContact(String contact) {
        if (contact == null || contact.trim().isEmpty()) {
            return "Organizer contact is required";
        }
        if (!PHONE_PATTERN.matcher(contact).matches()) {
            return "Invalid phone number format (10 digits)";
        }
        return null;
    }
    
    // Helper method: Check if string is not empty
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // Helper method: Check minimum length
    public static boolean hasMinLength(String value, int minLength) {
        return value != null && value.trim().length() >= minLength;
    }

    // Helper method: Check if valid date format
    public static boolean isValidDate(String dateStr) {
        return validateEventDate(dateStr) == null;
    }

    // Helper method: Check if end date is after start date
    public static boolean isEndDateAfterStartDate(String startDateStr, String endDateStr) {
        return validateDateRange(startDateStr, endDateStr) == null;
    }

    // Helper method: Check if string contains only letters and spaces
    public static boolean isAlphaWithSpaces(String value) {
        return value != null && !value.trim().isEmpty() && NAME_PATTERN.matcher(value).matches();
    }

    // Helper method: Check if valid phone number
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
}
