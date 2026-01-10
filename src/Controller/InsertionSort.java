/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Volunteer;
import java.util.LinkedList;


//sort linkedlist in ascending form
public class InsertionSort {
    public LinkedList<Volunteer> sortByNameAscending(LinkedList<Volunteer> volunteers){
        if (volunteers == null || volunteers.size() <= 1){
            return volunteers;
        }
        
        //create a new sorted list
        LinkedList<Volunteer> sortedList = new LinkedList<>();
        
        //insertion sort algorithm
        for (Volunteer volunteer : volunteers){
            insertInSortedOrderAscending(sortedList, volunteer);
        }
        return sortedList;
    }
    
    
    //sort linkedlist by name in descending format
    public LinkedList<Volunteer> sortByNameDescending(LinkedList<Volunteer> volunteers) {
        if (volunteers == null || volunteers.size() <= 1) {
            return volunteers;
        }

        LinkedList<Volunteer> sortedList = new LinkedList<>();

        for (Volunteer volunteer : volunteers) {
            insertInSortedOrderDescending(sortedList, volunteer);
        }

        return sortedList;
    }
    
    
    //inser volunteers in ascending order by namw
    private void insertInSortedOrderAscending(LinkedList<Volunteer> sortedList, Volunteer newVolunteer){
        if (sortedList.isEmpty()){
            sortedList.add(newVolunteer);
            return;
        }
        int position = 0;
        for (Volunteer volunteer : sortedList){
            //for ascending, insert before if the new name is smaller
            if (newVolunteer.getFullName().compareToIgnoreCase(volunteer.getFullName()) < 0){
                sortedList.add(position, newVolunteer);
                return;
            }
            position++;
        }
        sortedList.add(newVolunteer);
    }
    
    //insert volunteer in descending order by name
   private void insertInSortedOrderDescending (LinkedList<Volunteer> sortedList, Volunteer newVolunteer){
       if (sortedList.isEmpty()){
           sortedList.add(newVolunteer);
           return;
       }
       
       int position = 0;
       for (Volunteer volunteer : sortedList){
           //for descending: insert before if the new name is greater
           if (newVolunteer.getFullName().compareToIgnoreCase(volunteer.getFullName()) > 0){
               sortedList.add(position, newVolunteer);
               return;
           }
              position++;  
       }
       sortedList.add(newVolunteer);
   }
    

    /**
     * Display sorting process (for debugging/demo purposes)
     */
    public void demonstrateSorting(LinkedList<Volunteer> volunteers, boolean ascending) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   INSERTION SORT - " + (ascending ? "ASCENDING" : "DESCENDING") + "          ║");
        System.out.println("╠════════════════════════════════════════════╣");

        LinkedList<Volunteer> sortedList = new LinkedList<>();
        int step = 1;

        for (Volunteer volunteer : volunteers) {
            System.out.println("║ Step " + step + ": Inserting " + volunteer.getFullName());

            if (ascending) {
                insertInSortedOrderAscending(sortedList, volunteer);
            } else {
                insertInSortedOrderDescending(sortedList, volunteer);
            }

            System.out.print("║ Current sorted list: ");
            for (Volunteer v : sortedList) {
                System.out.print(v.getFullName() + " → ");
            }
            System.out.println();
            step++;
        }

        System.out.println("╚════════════════════════════════════════════╝\n");
    }
    
}
