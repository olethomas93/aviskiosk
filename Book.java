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
public class Book extends Literature{
    
     private String genre;
    private String author;
    private String title;
    private String publisher;
    
    
    public Book(String publisher
            ,String title
            ,String author
            ,String genre
            ,long purchasePrice
            ,int numberRecieved
            ,int year){
            
    
        
    super(publisher, purchasePrice, numberRecieved, year);    
    setTitle(title);        
    setGenre(genre);
    setAuthor(author);
    setPublisher(publisher);
        
    }
    

    private void setAuthor(String author) {
        
        this.author = author.toUpperCase();
        
    }

    private void setGenre(String genre) {
        
        this.genre = genre;
        
        
    }

    private void setTitle(String title) {
        
        this.title = title.toUpperCase();
        
        
    }

    /**
     * set title variable and check if the string is empty
     * @param publisher
     */
 
    public void setPublisher(String publisher)
    {
        
        if(publisher == null || publisher.isEmpty())
        {
            

            this.publisher ="INVALID TITLE";
            System.out.println("invalid title name");

           

        }
        else
        {
            this.publisher = publisher;
        }
    }
    
    
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return this.title;
    }
    
    /**
     * Returns a String with the titles publisher in uppercase
     * @return this.title a String with the titles publisher
     */
 public String getPublisher()

    {
        return this.publisher.toUpperCase();
    }

   
   
        
    
}
