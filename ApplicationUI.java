package gruppeinnlevering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator; 
import java.util.Map;

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
    protected Validator validInput  ;
    
  
    private HashMap<Literature,Integer> shoppingCart;
    

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
      "1. Add Periodical",
      "2. Add book"
    };
    private String[] subMenuItems2 =
    {
      "1. Find peridoical ",
      "2. Find Book",
      "3. Search for publisher "
            
      
    };
    
    private String[] subMenuItemShop =
    {
      "1. List everything in shop",
      "2. Find literature by title",
      "3. show shopping cart",
      "4. checkout"
           
      
    };
    
    
   

    /**
     * Creates an instance of the ApplicationUI User interface. 
     */
    public ApplicationUI() 
    {
       
        
        register = new LiteratureRegister(); 
        validInput = new Validator();
        
       
       shoppingCart = new HashMap<>();
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
                    this.listAllLiterature();
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
     * Lists all Literature in the collection of Literature
     */
    protected void listAllLiterature()
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
     * the variables are sendt to register. which creates and adds literature.
     * 
     *
     */
    protected void addLiterature(){
    
     int menuSelection = showMenu(subMenuItems);
        
     if(menuSelection== 1){
         
         View view = new PeriodicalLiteratureView(register);
         
         Literature  PeriodicalLiterature = view.createLiterature();
         
         register.addLiterature( PeriodicalLiterature);
     }
     if(menuSelection == 2){
         
         View view = new Bookview(register);
         Literature book = view.createLiterature();
         register.addLiterature(book);
     }
     
     
     
        
    }
        
/**
 * prints out search options for User
 */
           
 protected void searchForLiterature(){
     
     int menuSelection = showMenu(subMenuItems2);
     
     if(menuSelection ==1){
         View view = new PeriodicalLiteratureView(register);
         view.getSearchOptions();
       }
     if(menuSelection == 2){
         View view = new Bookview(register);
         view.getSearchOptions();
     }
     if(menuSelection == 3){
         searchForPublisher();
     }
     
 }
           

       
    
 protected void shopForLiterature() {
     
     
        
     int menuSelection = showMenu(subMenuItemShop);
     
      
     
     if(menuSelection ==1){
        
        ArrayList <Literature> list =  register.getList();
         
         listAllWithIndex(list);
         AddToCart(list);
        
    }
     if(menuSelection == 2){
         
         findLiteratureByTitle();
         
     }
     if(menuSelection == 3){
         
         
         ShowShoppingCart();
         
     }
     if(menuSelection == 4){
         checkOut();
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
        
        
        details.append("\n");
        details.append("Publisher: ");
        details.append(literature.getPublisher());
        details.append("\n");
        
        if(literature instanceof Book ){
            Book b = (Book)literature;
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
        if(literature instanceof Comics){
              Comics c = (Comics)literature;
              details.append("Title: ");
              details.append(c.getTitle());
              details.append("\n");
            
        }
        if(literature instanceof BookSeries){
           BookSeries c = (BookSeries)literature;
           details.append("Series: ");
           details.append(c.getSeries());
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

    
    /**
     * Lists all contents of literatureRegister with index number
     * @param list
     */
    
    public void listAllWithIndex(ArrayList<Literature> list){
    
       
     
     for(int i = 0; i< list.size();i++ ){
         
         System.out.println("\nindex number: "+(i)+"\n");
         
         System.out.println(getDetails(list.get(i)));
     }  
     
    
         
      
}
    
    /**
     * adds items to shopping cart
     */
    
   public void AddToCart(ArrayList<Literature> list){
             
    
     System.out.println("\nPlease enter the index number of what you want to add to shopping cart\n");
      
      int choise = validInput.checkInt(0, list.size());
      if(list.get(choise).getNumberInStock() == 0){
         
          System.out.println("\nOUT OF STOCK\n");
           shopForLiterature();
      }
      System.out.println("\nSure you want to add: \n");
      System.out.println(getDetails(list.get(choise)));
      System.out.println("\n");
      System.out.println("Type 'y' to add if not type 'n'");
      String option = validInput.checkString();
      if(option.equals("y")){
          System.out.println("\nPlease enter how many to add to cart:\n");
         
          int numberToAdd = validInput.checkInt(1, list.get(choise).getNumberInStock());
          
          
         
          
          this.shoppingCart.put(list.get(choise),numberToAdd);
          System.out.println("\nItem has been added to shoppingcart\n");
          
          shopForLiterature();
          
      }
      if(option.equals("n")){
          
          shopForLiterature();
          
      }
      
      
     }
  
/**
 * prints out contents of shopping cart
 */
   
public void ShowShoppingCart(){
    
    itemsInCart();
    
    for(Map.Entry<Literature,Integer> entry : this.shoppingCart.entrySet() ){
        
        System.out.print(entry.getValue()+" "+"items of : \n");
        System.out.println("\n");
        System.out.println(getDetails(entry.getKey()));
        
    }
    
}


/*
 decreases stock of items in shopping cart and clears the shoppingcart
*/

public void checkOut(){
    
    System.out.println("Items in shopping cart:\n");
    ShowShoppingCart();
    System.out.println("\n");
    System.out.println("Do you want to checkout? y/n");
    String choise = validInput.checkString();
    if(choise.equals("y")){
        
        for(Map.Entry<Literature,Integer> entry : this.shoppingCart.entrySet()){
            
            entry.getKey().SellLiterature(entry.getValue());
            
            
            
          
        }
        shoppingCart.clear();
    }
        
        if(choise.equals("n")){
            
            shopForLiterature();
        }
          
    
    
}


/**
 * prints out number of items in shopping cart
 */

    public void itemsInCart(){
    
    System.out.println(shoppingCart.size());
}

    private void deleteLiterature() {
        
        
        
        
    }

    
    
    private void findLiteratureByTitle() {
        
        
        
        System.out.println("Please enter name of title \n");
        String title = validInput.checkString();
        
        ArrayList<Literature> list = register.getListTitle(title);
        
        listAllWithIndex(list);
        
       AddToCart(list);
        
       }

    private void searchForPublisher() {
        
        
        System.out.println("Please enter name of publisher \n");
        String title = validInput.checkString();
        
        Iterator<Literature> it = register.getIteratorName(title);
        
        if(!it.hasNext())
        {
            System.out.println("no search results\n");
            
        }

        while(it.hasNext())
        {
            System.out.println(getDetails(it.next()));
        }
    }

   
    
} 
    
    
    
    
   

    
    
    


    