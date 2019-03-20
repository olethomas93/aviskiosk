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
public class Bookview extends ApplicationUI{
    
    private ValidInput validInput  ;
    private LiteratureRegister register;
    
    private String[] view = 
    {
       "Please type in name of publisher",
        "Plewase type in title",
        "Please type in author",
        "Please type in genre",
        "Please enter purchase price",
        "Please type in number received",
        "Please enter the year this Book was published",
        "Please enter the month",
        "Please enter the day of month"
    };
     
    private String[] searchOptions =
    {
        "1. Find book by title",
        "2. Find book by author"
            
        
    };
     
    
    public Bookview(LiteratureRegister myRegister){
        super();
        register = myRegister;
       validInput = new ValidInput();
   }
    
    
    
    
    
    
    
    
    
    public Literature createBook(){
       
       
       String publisher = "no title added";
        
        
         Literature book = null;
        
        
        
           System.out.println(view[0]);
           publisher = validInput.checkString();
            System.out.println(view[1]);
       String title = validInput.checkString();
      System.out.println(view[2]);
       String author = validInput.checkString();
       System.out.println(view[3]);
       String genre = validInput.checkString();
       System.out.println(view[4]);
       int purchasePrice = validInput.checkInt(1,1000);
       System.out.println(view[5]);
       int numberReceived = validInput.checkInt(1,200);
       System.out.println(view[6]);
       int year = validInput.checkInt(1000,3000);
       System.out.println(view[7]);
       int month = validInput.checkInt(1,12);
       System.out.println(view[8]);
       int dayOfMonth = validInput.checkInt(1,31);
       
        if(validInput.testDate(year, month, dayOfMonth))
        {
        

        
             book = new BookStandAlone( 
                     publisher
                     ,title
                     ,author
                     ,genre
                     ,purchasePrice
                     ,numberReceived
                     ,year  );
                    
            
            System.out.print("Book succesfully added");
        
    
            }
        
       
        return book;
        }
    
    void findBookByAuthor()
    {
        

        System.out.println("type in name of author");
        String searchString = validInput.stringScanner();

        Iterator<Literature> search = register.getIteratorAuthor(searchString);

        if(!search.hasNext()){
            System.out.println("Sorry Bro,couldn't find what you were looking for. Please try again");

        }

        while(search.hasNext())
        {

            System.out.println(getDetails(search.next()));   

        }
    }
    void findBookByTitle()
    {
        

        System.out.println("type in title name");
        String searchString = validInput.stringScanner();

        Iterator<Literature> search = register.getIteratorTitle(searchString);

        if(!search.hasNext()){
            System.out.println("Sorry Bro,couldn't find what you were looking for. Please try again");

        }

        while(search.hasNext())
        {

            System.out.println(getDetails(search.next()));   

        }
    }

    
    void getSearchOptions() {
        
        
        int menuSelection =  showMenu(searchOptions);
        
        if(menuSelection == 1){
            
            findBookByTitle();
    }
        if(menuSelection == 2){
            findBookByAuthor();
        }
       
       
   }
}
    

