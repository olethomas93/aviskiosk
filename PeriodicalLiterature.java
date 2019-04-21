/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author norby
 */
public class PeriodicalLiterature extends Literature {

    private int yearlyReleases;
    private LocalDate date;

    public PeriodicalLiterature(String publisher, int yearlyReleases,
            long purchasePrice, int numberRecieved, int year,
            int month, int dayOfMonth) {

        super(publisher, purchasePrice, numberRecieved, year);

        setYearlyReleases(yearlyReleases);
        setDateIssued(year, month, dayOfMonth);

    }

    /**
     * set yearly releases
     *
     * @param yearlyReleases
     */
    public void setYearlyReleases(int yearlyReleases) {
        if (yearlyReleases <= 0) {
            yearlyReleases = 0;
            throw new IllegalArgumentException("yearly releases can't be negative or zero");
        }

        this.yearlyReleases = yearlyReleases;
    }

    /**
     *
     * @return yearly releases
     */
    public int getYearlyReleases() {

        return this.yearlyReleases;
    }

    /**
     * Returns the date the newspaper was issued
     *
     * @return the date
     */
    public LocalDate getDateIssued() {
        return this.date;
    }

    /**
     * Returns date-object in String format.
     *
     * @return currentDate the date in String format
     */
    public String getDate() {
        String currentDate = this.date.toString();

        return currentDate;
    }

    /**
     * set date Issued
     *
     * @param year
     * @param month
     * @param dayOfMonth
     * @return
     */
    public void setDateIssued(int year, int month, int dayOfMonth) {

        if (year <= 0) {

            throw new IllegalArgumentException("year can't be negative or zero");
        }
        if (month <= 0 || month > 12) {

            throw new IllegalArgumentException("month can't be negative or zero");
        }
        if (dayOfMonth <= 0) {

            throw new IllegalArgumentException(" Day of month can't be negative or zero");
        }

        this.date = LocalDate.of(year, month, dayOfMonth);

    }

}
