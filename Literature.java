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

    public Literature(String publisher, long purchasePrice, int numberRecieved, int year) {

        setRetailPrice(purchasePrice);
        setNumberInStock(numberRecieved);
        setYearIssued(year);
        setPublisher(publisher);
    }

    /**
     * Returns the titles price for the paper
     *
     * @return the titles price for the paper
     */
    public double getPurchasePrice() {
        return this.purchasePrice;
    }

    /**
     * Returns the price out to the customer
     *
     * @return the price out to the customer
     */
    public double getRetailPrice() {
        return this.retailPrice;
    }

    /**
     * Returns the number of papers of this type
     *
     * @return paperStorage int that tells how many papers there left.
     */
    public int getNumberInStock() {
        return numberInStock;
    }

    /**
     * set retail price
     *
     * @param purchasePrice
     */
    public void setRetailPrice(double purchasePrice) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("Purchase price can't be negative or zero");
        }
        this.retailPrice = purchasePrice * 1.5;
        this.purchasePrice = purchasePrice;
    }

    /**
     * set number in stock when object is created
     *
     * @param numberRecieved
     */
    public void setNumberInStock(int numberRecieved) {
        if (numberRecieved <= 0) {
            throw new IllegalArgumentException("Number recieved can't be negative or zero");
        }

        this.numberInStock = numberRecieved;
    }

    /**
     * Change the number od issues of the given object
     *
     * @param numberToBuy
     */
    public void SellLiterature(int numberToBuy) {

        numberInStock = numberInStock - numberToBuy;

        if (numberInStock < 0) {
            numberInStock = 0;
        }

    }

    public boolean checkForNull(String checkString, String parameterName) {
        boolean check = false;

        try {

            if (checkString != null) {

                check = true;
            }
        } catch (NullPointerException e) {
            System.out.println(parameterName + ":" + "is null");
        }

        return check;
    }

    /**
     * updates the number of issues of the given object
     *
     * @param numberToAdd
     */
    public void AddToStock(int numberToAdd) {

        numberInStock = numberInStock + numberToAdd;

    }

    /**
     * set the year this book was issued
     *
     * @param year
     */
    private void setYearIssued(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("year can't be negative or zero");
        }

        this.year = year;
    }

    /**
     *
     * @return year issued
     */
    public int getYearIssued() {
        return this.year;
    }

    /**
     * sets the name of publisher
     *
     * @param publisher
     */
    private void setPublisher(String publisher) {
        if (publisher == null) {
            publisher = "";
        }

        publisher.trim();

        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("Publisher can't be null");
        }

        this.publisher = publisher.toUpperCase();
    }

    /**
     *
     * @return name of publisher
     */
    public String getPublisher() {
        return this.publisher.toUpperCase();
    }

}
