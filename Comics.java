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
public class Comics extends PeriodicalLiterature {

    private String title;

    public Comics(String name, String title, int yearlyReleases,
            long purchasePrice, int numberRecieved, int year,
            int month, int dayOfMonth) {

        super(name, yearlyReleases, purchasePrice, numberRecieved, year, month, dayOfMonth);
        setTitle(title);

    }

    /**
     * set title of comic
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
     *
     * @return title
     */

    public String getTitle() {
        return this.title;
    }

}
