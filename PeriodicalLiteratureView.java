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
    
    private ValidInput validInput  ;
    private LiteratureRegister register;
    
    private String[] view = 
    {
       "Please type in name of pulbihser",
        "Please type in yearly releases",
        "Please enter purchase price",
        "Please type in number received",
        "Please enter the year this paper is published",
        "Please enter the month",
        "Please enter the day of month"
    };
    
    private String[] searchOptions =
    {
        "1. Find newspaper by publisher"
        
    };
    
    
   public PeriodicalLiteratureView (LiteratureRegister myRegister){
         super();
       register = myRegister;
      
       validInput = new ValidInput();
   }
    
    
    
    public Literature createPeriodicalLiterature(){
       
       
       String publisher = "no title added";
        
        
         Literature paper = null;
        
        
        
           System.out.println(view[0]);
           publisher = validInput.checkString();
           System.out.println(view[1]);
       int yearlyReleases = validInput.checkInt(1,365);
       System.out.println(view[2]);
       long purchasePrice = validInput.checkInt(0,999);
       System.out.println(view[3]);
       int numberReceived = validInput.checkInt(1,99);
               System.out.println(view[4]);
       int year = validInput.checkInt(1000,3000);
       System.out.println(view[5]);
       int month = validInput.checkInt(1,12);
       System.out.println(view[6]);
       int dayOfMonth = validInput.checkInt(1,31);
       
        if(validInput.testDate(year, month, dayOfMonth))
        {
        

        
             paper = new Newspaper(publisher,yearlyReleases,purchasePrice,numberReceived,year
            ,month, dayOfMonth);
            
            System.out.print("Newspaper succesfully added\n");
           
        
    
            }
        
       
        return paper;
        }
    
    
    
    
    void findPeriodicalLiteratureByName()
    {
        

        System.out.println("type in publisher name");
        System.out.println("\n");
        String searchString = validInput.stringScanner();
       
        Iterator<Literature> search = register.getIteratorPublisher(searchString);

        if(!search.hasNext()){
            System.out.println("\nSorry Bro,couldn't find what you were looking for. Please try again\n");
           

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
           

