/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

import java.util.Iterator;

/**
 *
 * @author norby
 */
public abstract class View extends ApplicationUI {

    public abstract Literature createLiterature();

    public abstract void getSearchOptions();

    /**
     * prints out a list of hits of the given publisher name
     */
    void findPeriodicalLiteratureByPublisher() {

        System.out.println("type in publisher name");
        System.out.println("\n");
        String searchString = validInput.stringScanner();

        Iterator<Literature> search = register.getIteratorPublisher(searchString);

        if (!search.hasNext()) {
            System.out.println("\nSorry Bro,couldn't find what you were looking for. Please try again\n");
            findPeriodicalLiteratureByPublisher();

        }

        while (search.hasNext()) {

            System.out.println(getDetails(search.next()));
            System.out.println("\n");

        }
    }
}
