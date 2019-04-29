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
<<<<<<< HEAD
    private String title;

    public PeriodicalLiterature(String title,String publisher, int yearlyReleases,
            long purchasePrice, int numberRecieved, int year,
            int month, int dayOfMonth) {

        super(publisher, purchasePrice, numberRecieved, year);

=======
    
    
    
    
    
    public PeriodicalLiterature(String publisher, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth){
        
        super(publisher,purchasePrice,numberRecieved,year);
        
>>>>>>> parent of 2955594... hehie
        setYearlyReleases(yearlyReleases);
        setDateIssued(year, month, dayOfMonth);
        
    }

    
    
     public void setYearlyReleases(int yearlyReleases)
    {
        this.yearlyReleases = yearlyReleases;
    }
    
<<<<<<< HEAD
    /**
     * set title of comic
     *
     * @param title
     */
    private void setTitle(String title) {
        if (title == null) {
            title = "";
        }

        title.trim();

        if (title.isEmpty()) {
            throw new IllegalArgumentException("title can't be null");
        }
        this.title = title;

    }
    
     /**
     *
     * @return title
     */

    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @return yearly releases
     */
    public int getYearlyReleases() {

=======
    
    
    public int getYearlyReleases(){
        
>>>>>>> parent of 2955594... hehie
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

    
    
    
    
}
