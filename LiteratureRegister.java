package gruppeinnlevering;

import gruppeinnlevering.Literature;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class name: LiteratureRegister Represent a register, holdning newspapers
 *
 * @author gruppeprosjekt, Gruppe 33
 * @version v.1.0
 */
public class LiteratureRegister {

    private ArrayList<Literature> literatureCollection;
    private long balance;

    /**
     * Constructs a register for newspapers
     *
     */
    public LiteratureRegister() {
        this.literatureCollection = new ArrayList<>();
        balance = 0;

    }

    /**
     * add literature to the collection of Literature
     *
     * @param literature
     */
    public void addNewLiterature(Literature literature) {
        if (literature == null) {
            throw new IllegalArgumentException("can't add a null-object to collection");
        }

        this.literatureCollection.add(literature);
        setBalanceOut(literature.getPurchasePrice(), literature.getNumberInStock());

    }

    /**
     * Returns the iterator of literature collection
     *
     * @return Iterator of literature collection
     */
    public Iterator<Literature> getIterator() {

        return literatureCollection.iterator();
    }

    /**
     * Returns the Iterator of search-results in literature-collection
     *
     * @param publisher is the publisher which is searched for
     *
     * @return iterator of search results
     */
    public Iterator<Literature> getIteratorPublisher(String name) {

        ArrayList<Literature> searchResult = new ArrayList<>();

        for (Literature literature : this.literatureCollection) {

            if (literature.getPublisher().contains(name.toUpperCase())) {

                searchResult.add(literature);

            }
        }

        return searchResult.iterator();
    }

    /**
     * returns a itterator of mathcing authors
     *
     * @param author
     * @return Iterator of matching authors
     */
    public Iterator<Literature> getIteratorAuthor(String author) {
        ArrayList<Literature> searchResult = new ArrayList<>();
        for (Literature literature : this.literatureCollection) {

            if (literature instanceof BookStandAlone) {
                BookStandAlone book = (BookStandAlone) literature;

                if (book.getAuthor().contains(author.toUpperCase())) {

                    searchResult.add(literature);
                }

            }
        }

        return searchResult.iterator();
    }

    /**
     * return an Iterator of literature with given title
     *
     * @param title
     * @return iterator
     */
    public Iterator<Literature> getIteratorTitle(String title) {

        ArrayList<Literature> searchResult = new ArrayList<>();

        for (Literature literature : this.literatureCollection) {

            if (literature instanceof Book) {
                Book book = (Book) literature;
                if (book.getTitle().contains(title.toUpperCase())) {

                    searchResult.add(literature);
                }
            }
            if (literature instanceof Comics) {
                Comics comic = (Comics) literature;
                if (comic.getTitle().contains(title.toUpperCase())) {
                    searchResult.add(literature);
                }
            }

        }
        return searchResult.iterator();
    }

    public void setBalanceOut(double retailPrice, int numberOfItems) {

        this.balance = (long) (balance + (retailPrice * numberOfItems));
    }

    public void setBalanceIn(double purchasePrice, int numberOfItems) {

        this.balance = (long) (balance - (purchasePrice * numberOfItems));

    }

    /**
     * returns a Arraylist of Strings of all Series in Literature Collection
     *
     * @return ArrayList
     */
    public Iterator<String> getIteratorOfSeries() {

        ArrayList<String> series = new ArrayList<String>();

        for (Literature literature : this.literatureCollection) {

            if (literature instanceof BookSeries) {
                BookSeries book = (BookSeries) literature;

                series.add(book.getSeries());

            }
        }
        return series.iterator();
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
    public void addDailyLiterature() {

        addNewLiterature(new Newspaper("Stjørdalens blad", 250, 20, 15, 2, 2, 22));
        addNewLiterature(new Newspaper("Folkebladet", 220, 20, 15, 2019, 2, 22));
        addNewLiterature(new Newspaper("Inerøyingen", 52, 30, 5, 2019, 2, 22));
        addNewLiterature(new Newspaper("Nordlys", 364, 20, 15, 2019, 2, 22));
        addNewLiterature(new BookStandAlone("FORLAG", "SNOMANNEN", "JO NESBO", "KRIM", 2, 2, 2019));
        addNewLiterature(new BookStandAlone("FORLAG", "PAN", "KNUT HAMSUND", "KRIM", 12, 2, 2019));
        addNewLiterature(new BookStandAlone("FORLAG", "Davinci Code", "DARREN BROWN", "Crime", 12, 2, 2019));
        addNewLiterature(new BookStandAlone("FORLAG", "biblen", "JESUS", "fantasy", 12, 2, 1000));
        addNewLiterature(new BookStandAlone("FORLAG", "Hodejegerne", "JO NESBO", "KRIM", 12, 2, 2019));
        addNewLiterature(new Newspaper("publisher", 2, 10, 14, 1, 1, 1));
    }

    public float getBalance() {

        return this.balance;
    }

}
