package gruppeinnlevering;

import java.time.DateTimeException;
import java.time.LocalDate;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author norby
 */
public class Literature {
    
    private String publisher;
     private LocalDate date;
   
    private double purchasePrice;

    private double retailPrice;

    private int numberInStock;
    
    
    


public Literature(String publisher,long purchasePrice,int numberRecieved,int year,int month, int dayOfMonth)
{
    setPublisher(publisher);
    setRetailPrice(purchasePrice);
    setNumberInStock(numberRecieved);
    setDateIssued(year, month, dayOfMonth);

}
/**
     * Returns a String with the titles name in uppercase
     * @return this.title a String with the titles name
     */
 public String getPublisher()

    {
        return this.publisher.toUpperCase();
    }
 /**
     * Returns the titles price for the paper
     * @return the titles price for the paper
     */
 public double getPurchasePrice ()
    {
        return this.purchasePrice;
    }
  /**
     * Returns the price out to the customer
     * @return the price out to the customer
     */
 public double getRetailPrice()
    {
        return this.retailPrice;
    }
 /**
     * Returns the number of papers of this type
     * @return paperStorage int that tells how many papers there left.
     */
 public int getNumberInStock()
    {
        return numberInStock;
    }
 
  /**
     * Returns the date the newspaper was issued
     * @return the date
     */
    public LocalDate getDateIssued()
    {
        return this.date;
    }

   
    

    /**
     * Returns date-object in String format.
     * @return currentDate the date in String format
     */

    public String getDate()
    {
        String currentDate = this.date.toString();

        return currentDate;
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
    
    
    
    public void setRetailPrice(double purchasePrice)
    {
        this.retailPrice = purchasePrice * 1.5;
        this.purchasePrice = purchasePrice;
    }
    
    
    public void setNumberInStock(int numberRecieved)
    {
        this.numberInStock = numberRecieved;
    }
    
   

    


    
    
    public boolean setDateIssued(int year, int month, int dayOfMonth)
    {

      try
        {
          this.date = LocalDate.of(year, month, dayOfMonth);
        } 
        catch (DateTimeException e ) 
        {

           System.out.println("Exception thrown  :" + e); 
        }  

           

      boolean valid = true; 
        try{
          this.date = LocalDate.of(year, month, dayOfMonth);
        } catch (DateTimeException e ) {
           valid = false;
           System.out.println("Exception thrown  :" + e); 
        }  

            

           return valid;

     

    }
 /**
     * Change the stock.
     * @param numberToBuy
     */
    
    
    public void SellLiterature(int numberToBuy){
        
        numberInStock =- numberToBuy;
        
        
        
    }
    
    public void AddToStock(int numberToAdd){
        
        numberInStock =+ numberToAdd;
        
    }
    
}
