/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author norby
 */
public class PeriodicalLiterature extends Literature {
    
    
    
    private int yearlyReleases;
    private LocalDate date;
    private String name;
    
    
    
    
    public PeriodicalLiterature(String name, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth){
        
        super(purchasePrice,numberRecieved,year);
        
        setYearlyReleases(yearlyReleases);
        setDateIssued(year, month, dayOfMonth);
        setName(name);
    }

    
    
     public void setYearlyReleases(int yearlyReleases)
    {
        this.yearlyReleases = yearlyReleases;
    }
    
    
    
    public int getYearlyReleases(){
        
        return this.yearlyReleases;
    }
            
    
    /**
     * Returns the date the newspaper was issued
     * @return the date
     */
    public LocalDate getDateIssued()
    {
        return this.date;
    }

   
    

    /**
     * Returns date-object in String format.
     * @return currentDate the date in String format
     */

    public String getDate()
    {
        String currentDate = this.date.toString();

        return currentDate;
    }
    
    public String getName(){
        return this.name;
    }
    
    

public boolean setDateIssued(int year, int month, int dayOfMonth)
    {

      try
        {
          this.date = LocalDate.of(year, month, dayOfMonth);
        } 
        catch (DateTimeException e ) 
        {

           System.out.println("Exception thrown  :" + e); 
        }  

           

      boolean valid = true; 
        try{
          this.date = LocalDate.of(year, month, dayOfMonth);
        } catch (DateTimeException e ) {
           valid = false;
           System.out.println("Exception thrown  :" + e); 
        }  

            

           return valid;

     

    }

    private void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
