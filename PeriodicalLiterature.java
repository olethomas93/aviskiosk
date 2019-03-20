/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

/**
 *
 * @author norby
 */
public class PeriodicalLiterature extends Literature {
    
    
    
    private int yearlyReleases;
    
    
    
    
    
    public PeriodicalLiterature(String publisher, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth){
        
        super(publisher,purchasePrice,numberRecieved,year,month,dayOfMonth);
        
        setYearlyReleases(yearlyReleases);
        
    }

    
    
     public void setYearlyReleases(int yearlyReleases)
    {
        this.yearlyReleases = yearlyReleases;
    }
    
    
    
    public int getYearlyReleases(){
        
        return this.yearlyReleases;
    }
            
    
    
    
    
    
    
}
