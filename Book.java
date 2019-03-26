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
    
    
    
    public Book(String publisher
            ,String title
            ,String author
            ,String genre
            ,long purchasePrice
            ,int numberRecieved
            ,int year){
            
    
        
    super( publisher, purchasePrice, numberRecieved, year);    
    setTitle(title);        
    setGenre(genre);
    setAuthor(author);
        
        
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

    

    
    
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return this.title;
    }
    
    

   
   
        
    
}
