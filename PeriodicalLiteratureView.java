/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

import java.util.Iterator;

/**
 *
 * @author norby
 */
public class PeriodicalLiteratureView extends ApplicationUI{
    
    private Validator validInput  ;
    private LiteratureRegister register;
    
    private String[] view = 
    {
       "Please type in name of publisher",
        "Please type in title",
        "Please type in yearly releases",
        "Please enter purchase price",
        "Please type in number received",
        "Please enter the year this paper is published",
        "Please enter the month",
        "Please enter the day of month"
    };
    
    private String[] whatPeriodicalLiterature =
    {
        "1. Newspaper",
        "2. Comic"
    };
    
    private String[] searchOptions =
    {
        "1. Find newspaper by publisher"
        
    };
    
    
   public PeriodicalLiteratureView (LiteratureRegister myRegister){
         super();
       register = myRegister;
      
       validInput = new Validator();
   }
    
    
    
    public Literature createPeriodicalLiterature(){
       
       
       
        
        
         Literature periodicalLiterature = null;
       
        System.out.println("\nPlease choose what you want  to add");
        
       int menuSelection = showMenu(whatPeriodicalLiterature);
        
       if(menuSelection == 1){
          periodicalLiterature = userInput(menuSelection);
           
       }
       if(menuSelection ==2){
           periodicalLiterature = userInput(menuSelection);
       }
        
          
        
        
       
        
        
        
            
            
            System.out.print("Newspaper succesfully added\n");
           
        
    
            
        
       
        return periodicalLiterature;
        }
    
    
    Literature userInput(int selection){
        
        String publisher = "no title added";
        Literature literature = null;
        
      switch(selection){  
        
          case 1:  
           System.out.println(view[0]);
           publisher = validInput.checkString();
           System.out.println(view[2]);
       int yearlyReleases = validInput.checkInt(1,365);
       System.out.println(view[3]);
       long purchasePrice = validInput.checkInt(0,999);
       System.out.println(view[4]);
       int numberReceived = validInput.checkInt(1,99);
               System.out.println(view[5]);
       int year = validInput.checkInt(1000,3000);
       System.out.println(view[6]);
       int month = validInput.checkInt(1,12);
       System.out.println(view[7]);
       int dayOfMonth = validInput.checkInt(1,31);
       
        if(!validInput.testDate(year, month, dayOfMonth))
        {
           System.out.println("Date Error. instance was not added\n");
        }
        
        literature = new Newspaper(publisher,yearlyReleases,purchasePrice,numberReceived,year,month,dayOfMonth);
       
        break;
        
          case 2:
               System.out.println(view[0]);
           publisher = validInput.checkString();
           System.out.println(view[1]);
           String title = validInput.checkString();
           System.out.println(view[2]);
        yearlyReleases = validInput.checkInt(1,365);
       System.out.println(view[3]);
        purchasePrice = validInput.checkInt(0,999);
       System.out.println(view[4]);
        numberReceived = validInput.checkInt(1,99);
               System.out.println(view[5]);
        year = validInput.checkInt(1000,3000);
       System.out.println(view[6]);
        month = validInput.checkInt(1,12);
       System.out.println(view[7]);
        dayOfMonth = validInput.checkInt(1,31);
       
        if(!validInput.testDate(year, month, dayOfMonth))
        {
           System.out.println("Date Error. instance was not added\n");
        }
        
        literature = new Comics(publisher,title,yearlyReleases,purchasePrice,numberReceived,year,month,dayOfMonth);
        break;
      }
        
        return literature;
    }
    
    
    
    
    
    
    
    
    void findPeriodicalLiteratureByName()
    {
        

        System.out.println("type in publisher name");
        System.out.println("\n");
        String searchString = validInput.stringScanner();
       
        Iterator<Literature> search = register.getIteratorPublisher(searchString);

        if(!search.hasNext()){
            System.out.println("\nSorry Bro,couldn't find what you were looking for. Please try again\n");
           findPeriodicalLiteratureByName();

        }

        while(search.hasNext())
        {

            System.out.println(getDetails(search.next())); 
            System.out.println("\n");

        }
    }
    
    void findNewspaperByDate(){
        
    }
    
    
    void getSearchOptions(){
        
        int menuSelection =  showMenu(searchOptions);
        
        if(menuSelection == 1){
            
            findPeriodicalLiteratureByName();
            
        }
        
        
        
    }
       
       
   }
           

