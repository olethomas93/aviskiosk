/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author norby
 */
public class ValidInput {
    
   
    
    
    
    
    
    public ValidInput(){

}

   
    
    
    //            }
    
    
    
    
    
    

/**
     * creates a new Scanner
     * reades next input as String
     * 
     * @return input String typed by user
     */

    public String stringScanner(){
    
        Scanner reader = new Scanner(System.in);
        String input  = reader.nextLine();

        return input;
    }

    /**
     * creates a new scanner
     * Reades next input as int
     * 
     * @return int input returns the number written by user.
     */

    public int intScanner(){
    
        Scanner reader = new Scanner(System.in);
        int input = reader.nextInt();

        return input;
    }

    
        
        

     
    /** 
     * Check if String is not null or empty
     * 
     * @return booelan true/false
     */

    public String checkString(){
    
        String stringToCheck = "error";
        
        boolean stringValid = false;
        
        while(!stringValid){
           stringToCheck = stringScanner();  

        if(stringToCheck == null || stringToCheck.isEmpty())
        {
            System.out.println("String is empty, PLease try again");
        }
        else{
            stringValid = true;
        }
        }
        
        
        return stringToCheck;
    }

    /**

     * Check if value is inside av given range
     * 
     * @param value
     * 
     * @param min
     * @param max
     * @return boolean true/false
     */

    public int checkInt(int min, int max){
        
        int valueToCheck = 0;
        
        boolean check = false;
        while(!check){
         valueToCheck = intScanner();
        
        if(valueToCheck>=min && valueToCheck<=max)
        {
            check = true;
        }
        else{
            System.out.println("Invalid Input"+"Min: "+ min+ "Max: "+ max);
        }
        }

        return  valueToCheck;
    }

    
public boolean testDate(int year, int month, int dayOfMonth){
    
        boolean valid = true; 
        try{
            LocalDate date = LocalDate.of(year, month, dayOfMonth);
        } catch (DateTimeException e ) {
            valid = false;
            System.out.println("Exception thrown  :" + e); 
        }
        return valid;
    }

    
}

