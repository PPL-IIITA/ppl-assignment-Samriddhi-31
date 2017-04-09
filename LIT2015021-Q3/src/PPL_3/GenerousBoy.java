package PPL_3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Class that defines the attributes of and simulates Virtual World Generous Boy.
 * Child class of abstract class Boy.
 * Implements the abstract methods of parent class Boy.
 * 
 */
public class GenerousBoy extends Boy {
     /**
     * Constructor to initialize the attributes of GenerousBoy object with given values.
     * Includes call to super class constructor.
     * @param a name of Boy
     * @param b attractiveness of Boy
     * @param c intelligence level of Boy
     * @param d budget of Boy
     * @param e minimum attraction requirements
     */
    public GenerousBoy(String a,int b,int c, int d,int e){
        super(a,b,c,d,e);
    }
    /**
    *Method implemented which simulates the activity of selecting gifts to be included in the Gift Basket
     * Overrides parent class method
     * @param ob Girl object (Girlfriend of the Boy)
     * @param gift_ob   List of Gifts
     * @param log BufferedWriter object
     * @throws java.io.IOException
     * 
     */
    public void selectGifts(Girl ob, Gift gift_ob[],BufferedWriter log) throws IOException {
                int x=gift_ob.length-1,price;
                Date date=new Date();
                while(budget>money_spent){
                    System.out.println(name+" sent gift to "+ob.name+": Gift price = "+gift_ob[x].getPrice()+" Gift Type = "+gift_ob[x].toString());
                    log.write(date.toString()+" "+name+" sent gift to "+ob.name+": Gift price = "+gift_ob[x].getPrice()+" Gift Type = "+gift_ob[x].toString()+System.lineSeparator());
                    price=gift_ob[x].getPrice();
                    x--;
                    money_spent+=price;
                }
    }
    /**
     * Method to calculate happiness of GenerousBoy
     * Overrides parent class method.
     * @param gf Girl object (Girlfriend of Boy)
     */
    
    public void calcHappiness(Girl gf){
        happiness=gf.happiness;
    }
}

