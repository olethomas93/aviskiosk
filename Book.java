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
public class Book extends Literature {

    private String genre;
    private String author;
    private String title;
    private String publisher;

    public Book(String publisher,
             String title,
             String author,
             String genre,
             long purchasePrice,
             int numberRecieved,
             int year) {

        super(publisher, purchasePrice, numberRecieved, year);
        setTitle(title);
        setGenre(genre);
        setAuthor(author);
        setPublisher(publisher);

    }

    /**
     * set Author
     *
     * @param author
     */

    private void setAuthor(String author) {
        if (author == null) {
            author = "";
        }

        author.trim();

        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author can't be null");
        }
        this.author = author;

    }

    /**
     * set genre
     *
     * @param genre
     */

    private void setGenre(String genre) {
        if (genre == null) {
            genre = "";
        }

        genre.trim();

        if (genre.isEmpty()) {
            throw new IllegalArgumentException("genre can't be null");
        }
        this.genre = genre;

    }

    /**
     * set title
     *
     * @param title
     */
    private void setTitle(String title) {

        if (title == null) {
            title = "";
        }
        title.trim();
        if (title.isEmpty()) {
            throw new IllegalArgumentException("title can't be null");
        }

        this.title = title;

    }

    /**
     * set title variable and check if the string is empty
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {

        if (publisher == null) {
            publisher = "";
        }

        publisher.trim();

        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("publisher can't be null");
        }
        this.publisher = publisher;

    }

    /**
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return genre
     */

    public String getGenre() {
        return genre;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns a String with the publisher in uppercase
     *
     * @return this.title a String with the titles publisher
     */
    public String getPublisher() {
        return this.publisher.toUpperCase();
    }

}
