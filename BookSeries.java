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
public class BookSeries extends Book {

    private String series;

    public BookSeries(String publisher,
             String title,
             String author,
             String genre,
             String series,
             long purchasePrice,
             int numberRecieved,
             int year
    ) {

        super(publisher, title, author, genre, purchasePrice, numberRecieved, year);

        setSeries(series);
    }

    /**
     * set serie
     *
     * @param series
     */
    private void setSeries(String series) {
        if (series == null) {
            series = "";
        }

        series.trim();

        if (series.isEmpty()) {
            throw new IllegalArgumentException("genre can't be null");
        }
        this.series = series;

    }

    /**
     *
     * @return series
     */
    public String getSeries() {
        return this.series;
    }
}
