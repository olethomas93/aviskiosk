package gruppeinnlevering;

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
public class Newspaper extends PeriodicalLiterature
{
    
     
     

   

   

    /**
     * Constructs a newspaper object and set the values asked for
     * The date is the only parameter which the values typed in the
     * parameter are checked. purchasePrice are an absolute value.
     * 
     * @param name
     * @param yearlyReleases  how many releases per year
     * @param purchasePrice represents the price set by the title in NOK
     * @param numberRecieved
     * @param year
     * @param month
     * @param dayOfMonth
     
     
     */
    public Newspaper(String title,String publisher, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth)
    {
        
        super(title, publisher,yearlyReleases,purchasePrice,numberRecieved,year,month,dayOfMonth);
        
       
        
        
      
        
    }
    
    
 

    
        
    
}
