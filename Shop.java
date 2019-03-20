/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gruppeinnlevering;

import java.util.ArrayList;

/**
 *
 * @author norby
 */
public class Shop extends ApplicationUI {
    
 private final LiteratureRegister register; 
 private ArrayList shoppingCart;
    
public Shop(LiteratureRegister myRegister ){
    
    register = myRegister; 
    
    shoppingCart = new ArrayList<>();
}    
    
   


public void listAll(){
    
     ArrayList<Literature> list = register.getList();
     
     for(int i = 0; i< list.size();i++ ){
         
         System.out.println("\nindex number: "+i+"\n");
         
         System.out.println(getDetails(list.get(i)));
     }    
         
      System.out.println("\nPlease enter the index number of what you want to add to shopping cart\n");
      
     
         
    
}
    
    
}
