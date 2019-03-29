package gruppeinnlevering;


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
public abstract class Literature {
    
   
    
    private LocalDate date;
   
    private double purchasePrice;

    private double retailPrice;

    private int numberInStock;
    
    private int year;
    private String publisher;
    
    
    


public  Literature(String publisher,long purchasePrice,int numberRecieved,int year)
{
    
    setRetailPrice(purchasePrice);
    setNumberInStock(numberRecieved);
    setYearIssued(year);
     setPublisher(publisher);
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
 
  
    
    
    
    
    
    public void setRetailPrice(double purchasePrice)
    {
        this.retailPrice = purchasePrice * 1.5;
        this.purchasePrice = purchasePrice;
    }
    
    
    public void setNumberInStock(int numberRecieved)
    {
        this.numberInStock = numberRecieved;
    }
    
   

    


    
    
    
 /**
     * Change the stock.
     * @param numberToBuy
     */
    
    
    public void SellLiterature(int numberToBuy){
        
        numberInStock = numberInStock - numberToBuy;
        
        if(numberInStock < 0){
            numberInStock = 0;
        }
        
        
        
    }
    
    public void AddToStock(int numberToAdd){
        
        numberInStock =+ numberToAdd;
        
    }

    private void setYearIssued(int year) {
        this.year = year;
    }
    
    public int getYearIssued(){
        return this.year;
    }
    
    private void setPublisher(String publisher) {
        this.publisher = publisher.toUpperCase();
    }
    
    public String getPublisher(){
        return this.publisher.toUpperCase();
    }
    
}
