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
<<<<<<< HEAD

    

    public Comics(String title, String publisher, int yearlyReleases,
            long purchasePrice, int numberRecieved, int year,
            int month, int dayOfMonth) {

        super(title,publisher, yearlyReleases, purchasePrice, numberRecieved, year, month, dayOfMonth);
        

    }

    

   

=======
    
    private String title;
    
    
    public Comics(String name,String title, int yearlyReleases,
    long purchasePrice, int numberRecieved, int year, 
    int month, int dayOfMonth){
        
        super(name,yearlyReleases,purchasePrice,numberRecieved,year,month,dayOfMonth);
        setTitle(title);
    
    }

    private void setTitle(String title) {
        
        this.title = title;
        
    }
    
    public String getTitle(){
        return this.title;
    }
    
    
    
    
    
>>>>>>> parent of 2955594... hehie
}
