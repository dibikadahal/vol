/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ALIENWARE
 */
public class Event {
    private String eventId;
    private String eventName;
    private String description;
    private String startDate;
    private String endDate;
    private String location;
    private String eventType;
    private String eventStatus;
    private String organizerName;
    private String organizerContact;
    
    //constructor
    public Event(String eventId, String eventName, String description, String startDate, String endDate, String location, String eventType,
            String eventStatus,  String organizerName, String organizerContact){
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.eventType = eventType;
        this.eventStatus = eventStatus;
        this.organizerName = organizerName;
        this.organizerContact = organizerContact;
    }
    
    //getters
    public String getEventId(){
        return eventId;
    }
    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public String getOrganizerContact() {
        return organizerContact;
    }
    
    
    //SETTERS
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public void setOrganizerContact(String organizerContact) {
        this.organizerContact = organizerContact;
    }

    
    //CALCULATE DURATION
    public String getDuration(){
        try{
            //parse the dates
            java.time.LocalDate start = java.time.LocalDate.parse(startDate);
            java.time.LocalDate end = java.time.LocalDate.parse(endDate);
            
            //calculate the number of days(inclusive)
            long days = java.time.temporal.ChronoUnit.DAYS.between(start, end) + 1;
            
            //return formatted string
            if (days==1){
                return "1 day";
            }else{
                return days + " days";
            }
        }catch (Exception e){
            //if date parsing fails, return default
            return startDate.equals(endDate) ? "1 day" : "Multi-day";
        }
    }
}
