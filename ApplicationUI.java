package gruppeinnlevering;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator; 

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author gruppeprosjekt, Gruppe 33
 * @version 1.0
 */
public class ApplicationUI 
{
   
    protected LiteratureRegister register;
    

    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = 
        {
            "1. List all literature",
            "2. Add new literature",
            "3. Remove literature",
            "4. Find literature",
            "5. Shop for literature"
        };
    
    private String[] subMenuItems =
    {
      "1. Add newspaper",
      "2. Add book"
    };
    private String[] subMenuItems2 =
    {
      "1. Find Newspaper ",
      "2. Find Book"
      
    };
    
    private String[] subMenuItemShop =
    {
      "1. List everything in shop",
      "2. Find literature by title",
      
    };

   

    /**
     * Creates an instance of the ApplicationUI User interface. 
     */
    public ApplicationUI() 
    {
     
        System.out.println("\n**** Application v1.0 ****\n");
        register = new LiteratureRegister(); 
        register.addDailyLiterature();

    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() 
    {
        

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection) 
                {
                    case 1:
                    this.listAllProducts();
                    break;

                    case 2:
                    this.addLiterature();
                    break;
                    
                    case 3:
                    this.deleteLiterature();
                    break;

                    case 4:
                    this.searchForLiterature();
                    break;
                    
                    case 5:
                    this.shopForLiterature();
                    break;

                    case 6:
                    System.out.println("\nThank you for using Application v0.1. Bye!\n");
                    quit = true;
                    break;

                    default:
                }
            } 
            catch (InputMismatchException ime) 
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }        

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @param menuItems
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    protected int showMenu(String[] menuItems) throws InputMismatchException 
    {
        
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
            System.out.println("\n");
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---

   
   
    /**
     * Lists all newspapers in the collection of newspapers
     */
    protected void listAllProducts()
    {
       

        Iterator<Literature> search = register.getIterator();
        if(!search.hasNext())
        {
            System.out.println("list is empty\n");
            
        }

        while(search.hasNext())
        {
            System.out.println(getDetails(search.next()));
        }
    }

    

    


    /**
     * Let the user set parameters, if all the typing from user are validated
     * the variables are sendt too register. which creates and adds newspaper.
     * 
     *
     */
    protected void addLiterature(){
    
     int menuSelection = showMenu(subMenuItems);
        
     if(menuSelection== 1){
         
         PeriodicalLiteratureView view = new PeriodicalLiteratureView(register);
         
         Literature paper = view.createPeriodicalLiterature();
         
         register.addLiterature(paper);
     }
     if(menuSelection == 2){
         
         Bookview view = new Bookview(register);
         Literature book = view.createBook();
         register.addLiterature(book);
     }
     
     
     
        
    }
        
/**
 * prints out search options for User
 */
           
 protected void searchForLiterature(){
     
     int menuSelection = showMenu(subMenuItems2);
     
     if(menuSelection ==1){
         PeriodicalLiteratureView view = new PeriodicalLiteratureView(register);
         view.getSearchOptions();
       }
     if(menuSelection == 2){
         Bookview view = new Bookview(register);
         view.getSearchOptions();
     }
     
 }
           

       
    
 private void shopForLiterature() {
        
     int menuSelection = showMenu(subMenuItemShop);
     
     Shop shop = new Shop(register);
     
     if(menuSelection ==1){
        
        shop.listAll();
        
    }
 }
   
    
    
    
    
    /**
     * creates a String of details of newspaper
     * @param literature
     * @return details
     *
     */
    protected StringBuilder getDetails(Literature literature){
    
        StringBuilder details = new StringBuilder();
        
        details.append("_________________________");
        details.append("\n");
        details.append("Publisher: ");
        details.append(literature.getPublisher());
        details.append("\n");
        
        if(literature instanceof BookStandAlone ){
            BookStandAlone b = (BookStandAlone)literature;
            details.append("Author: ");
            details.append(b.getAuthor());
            details.append("\n");
            details.append("Title: ");
            details.append(b.getTitle());
            details.append("\n");
            details.append("Genre: ");
            details.append(b.getGenre());
            details.append("\n");
        }
        
        details.append("Retail Price: ");
        details.append(literature.getRetailPrice());
        details.append("\n");
        details.append("Purchase Price: ");
        details.append(literature.getPurchasePrice());
        details.append("\n");
        details.append("Number in stock: ");
        details.append(literature.getNumberInStock());
        details.append("\n");
        details.append("Year Issued: ");
        details.append(literature.getYearIssued());
        details.append("\n");
        
        if(literature instanceof PeriodicalLiterature){
            PeriodicalLiterature p = (PeriodicalLiterature)literature;
            details.append("Date Issued: ");
            details.append(p.getDateIssued());
            details.append("\n");
        }    
         details.append("_________________________");   
        
    
    return details;
    }

    
   

    private void deleteLiterature() {
        
        
        
        
    }

   
    
    
    
    
    
    
    
    /**
     * Search the collection of Newspapers by name.
     * 
     * Prints out details of newspaper in the search result 

     */

    
    
    
}

    