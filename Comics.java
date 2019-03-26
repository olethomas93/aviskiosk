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
public class Comics extends PeriodicalLiterature {
    
    String title;
    
    
    public Comics(String publisher,String title, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth){
        
        super(publisher,yearlyReleases,purchasePrice,numberRecieved,year,month,dayOfMonth);
        setTitle(title);
    
    }

    private void setTitle(String title) {
        
        this.title = title;
        
    }
    
    
    
    
    
}
