
import gruppeinnlevering.ApplicationUI;


/**
 * The Main-class of the application. This class only holds the main()-method
 * to start the application.
 * 
 * @author gruppeprosjekt, Gruppe 33 
 * @version 1.0
 */
public class Main 
{
    /**
     * The main entry for the application.
     * @param args arguments provided during startup of the application
     */
    public static void main(String[] args)
    {
     try
     {
        ApplicationUI appUI = new ApplicationUI();
        
        System.out.println("\n**** Application v1.0 ****\n");
        appUI.start();
     }
     catch (NullPointerException e){
         System.out.println("Sorry error error occurred, Please call help desk +4792691204 ");
     }
    }
}
