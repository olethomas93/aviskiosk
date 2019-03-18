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
    private String series;
    
    
    public Book(String publisher
            ,String title
            ,String author
            ,String genre
            ,long purchasePrice
            ,int numberRecieved
            ,int year 
            ,int month
            , int dayOfMonth){
        
        super(publisher,purchasePrice,numberRecieved,year,month,dayOfMonth);
        
        setTitle(title);        
        setGenre(genre);
        setAuthor(author);
        setSeries(series);
        
        
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

    private void setSeries(String series) {
        
        this.series = series;
    }

    
    
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getSeries() {
        return series;
    }

    
   

    
    
    
    
    
}
