package gruppeinnlevering;

import gruppeinnlevering.Literature;
import java.util.ArrayList;
import java.util.Iterator; 
/**
 * Class name: LiteratureRegister
 Represent a register, holdning newspapers
 * 
 * @author gruppeprosjekt, Gruppe 33
 * @version v.1.0
 */
public class LiteratureRegister
{
    private ArrayList<Literature> literatureCollection;

    /**
     * Constructs a register for newspapers
     * 
     */
    public LiteratureRegister()
    {
        this.literatureCollection = new ArrayList<>();

    }

    
    
    /**
     * add literature to the collection of Literature
     * @param literature 
     */
    
    
    public void addLiterature(Literature literature)
    {
        this.literatureCollection.add(literature);
    }
    
    
    
    
    
    /**
     * Remove a paper from the collection
     * @param title
     */
    public void removePaper(String title)
    {
        for (Literature literature : this.literatureCollection){
        
            if (literature instanceof Newspaper){
                
                Newspaper paper = (Newspaper)literature;
                
                if(paper.getPublisher().equals(title)){
                   
                    literatureCollection.remove(literature);
                    
                }
                
               
            
            
                

            
        }  

        
    }
    }
    
  

    /**
     * Returns the iterator of literature collection
     * @return  Iterator of literature collection
     */
    public Iterator<Literature> getIterator()
    {

         
        return literatureCollection.iterator();
    }

    /**
     * Returns the Iterator of search-results in literature-collection 
     *
     * @param publisher is the publisher which is searched for
     * 
     * @return iterator of search results
     */
    public Iterator<Literature> getIteratorPublisher(String publisher){
    
        ArrayList<Literature> searchResult = new ArrayList<>();
         
        
        for (Literature literature : this.literatureCollection){ 
            
            
        
            if (literature.getPublisher().contains(publisher.toUpperCase())){
            
                searchResult.add(literature);

            }
        }  
        
        
        return searchResult.iterator();
    }
    
    
    
    public Iterator<Literature> getIteratorAuthor(String author)
    {
        ArrayList<Literature> searchResult = new ArrayList<>();
        for (Literature literature : this.literatureCollection) {
        
            if(literature instanceof BookStandAlone){
                BookStandAlone book = (BookStandAlone)literature;
                
                if(book.getAuthor().contains(author.toUpperCase())){
                    
                     searchResult.add(literature);
                }
                
               
            }
        }  
        
        
        return searchResult.iterator();
    }
    
    
    public Iterator<Literature> getIteratorTitle(String title){
        
        ArrayList<Literature> searchResult = new ArrayList<>();
        
        for (Literature literature : this.literatureCollection) {
        
            if(literature instanceof BookStandAlone){
                BookStandAlone book = (BookStandAlone)literature;
                
              
                if(book.getTitle().contains(title.toUpperCase())){
                    
                     searchResult.add(literature);
                }
                
               
            }
        }  
        return searchResult.iterator();
    }
    
    public ArrayList<Literature> getListTitle(String title){
        
         ArrayList<Literature> searchResult = new ArrayList<>();
       
        for (Literature literature : this.literatureCollection) {
                
           
            
            if(literature instanceof BookStandAlone){
                BookStandAlone book = (BookStandAlone)literature;
                
              
                if(book.getTitle().contains(title.toUpperCase())){
                    
                     searchResult.add(literature);
                    
                }
                
               
            }
        }  
        return searchResult;
        
        
    }
    
    public ArrayList<Literature> getList(){
        
        return literatureCollection;
        
    }
    
   
       
       
       public ArrayList<String> getSeriesList(){
        
        
         ArrayList<String> series = new ArrayList<String>(); 
        
        for (Literature literature : this.literatureCollection) {
             int i = 0;
            
             if(literature instanceof BookSeries){
                BookSeries book = (BookSeries)literature;
                
                
                series.add(book.getSeries());
               
                i++;
               
            }
        }  
        return series;
    } 
    

    /**
     * Returns the Iterator of search-results in newspaper-collection
     * 
     * 
     * @param year is the year searched for
     * @ month is the month searched for
     * @param dayOfMonth is the day searched for
     */
    /*public Iterator<Literature> getIterator(int year, int month, int dayOfMonth)
    {
    ArrayList<Literature> papersFound = new ArrayList<>();
    LocalDate compareDate = LocalDate.of(year, month, dayOfMonth);
    
    for (Literature l : this.literatureCollection)
    {
    if (l.getDateIssued().equals(compareDate))
    {
    papersFound.add(l);
    
    }
    }
    
    
    
    return papersFound.iterator();
    }
    
    /***/
    /*  * A method who creates objects of the class Newspaper
    * this method is just for testing.
    */
    
    
    public void addDailyLiterature()
    {
        literatureCollection.add(new Newspaper("Stjørdalens blad", 250, 20, 15, 2019, 2, 22));
        literatureCollection.add(new Newspaper("Folkebladet", 220, 20, 15, 2019, 2, 22));  
        literatureCollection.add(new Newspaper("Inerøyingen", 52, 30, 5, 2019, 2, 22));  
        literatureCollection.add(new Newspaper("Nordlys", 364, 20, 15, 2019, 2, 22));
        literatureCollection.add(new BookStandAlone("FORLAG", "SNOMANNEN", "JO NESBO", "KRIM", 12, 2, 2019));
        literatureCollection.add(new BookStandAlone("FORLAG", "PAN", "KNUT HAMSUND", "KRIM", 12, 2, 2019));
        literatureCollection.add(new BookStandAlone("FORLAG", "DAVINCI CODE", "DARREN BROWN", "KRIM", 12, 2, 2019));
        literatureCollection.add(new BookStandAlone("FORLAG", "BIBELEN", "JESUS", "fantasy", 12, 2, 1000));
        literatureCollection.add(new BookStandAlone("FORLAG", "Hodejegerne", "JO NESBO", "KRIM", 12, 2, 2019));

    }

}
