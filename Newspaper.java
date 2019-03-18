package gruppeinnlevering;

import gruppeinnlevering.Literature;
import java.time.LocalDate;

/**
 * Class name: Newspaper
 * Represents a newspaper
 * stores information about the newspaper
 * 
 *
 * @author gruppeprosjekt, Gruppe 33
 * @version 1.0
 */
public class Newspaper extends Literature
{
    
    private int yearlyReleases;
     private LocalDate date;

   

   

    /**
     * Constructs a newspaper object and set the values asked for
     * The date is the only parameter which the values typed in the
     * parameter are checked. purchasePrice are an absolute value.
     * 
     * @param publisher represents the publisher of the paper
     * @param yearlyReleases says how many releases per
     * @param purchasePrice represents the price set by the title in NOK
     * @param numberRecieved
     * @param year
     * @param month
     * @param dayOfMonth
     
     
     */
    public Newspaper(String publisher, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth)
    {
        
        super(publisher,purchasePrice,numberRecieved,year,month,dayOfMonth);
        
        

        
        
      
        
    }
    
    


 

    
        
    public void setYearlyReleases(int yearlyReleases)
    {
        this.yearlyReleases = yearlyReleases;
    }
    
    
    
    public int getYearlyReleases(){
        
        return this.yearlyReleases;
    }
            
    
    
    
    
    
    
}
