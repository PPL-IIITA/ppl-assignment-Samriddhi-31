package PPL_3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Class that defines the attributes of and simulates Virtual World Geek Boy.
 * Child class of abstract class Boy.
 * Implements the abstract methods of parent class Boy.
 * 
 */
public class Geek extends Boy {
    /**
     * Constructor to initialize the attributes of Geek object with given values.
     * Includes call to super class constructor.
     * @param a name of Boy
     * @param b attractiveness of Boy
     * @param c intelligence level of Boy
     * @param d budget of Boy
     * @param e minimum attraction requirements
     */
    public Geek(String a,int b,int c, int d,int e){
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
        int x=0,y=100,price;
        Date date=new Date();
            money_spent+=gift_ob[100].getPrice();
          
            while(ob.m_cost>money_spent){
                System.out.println(name+" sent gift to "+ob.name+": Gift price = "+gift_ob[x].getPrice()+" Gift Type = "+gift_ob[x].toString());
                log.write(date.toString()+" "+name+" sent gift to "+ob.name+": Gift price = "+gift_ob[x].getPrice()+" Gift Type = "+gift_ob[x].toString()+System.lineSeparator());
                price=gift_ob[x].getPrice();
                x++;
                money_spent+=price;
                    
            }
            System.out.println(name+" sent gift to "+ob.name+": Gift price = "+gift_ob[100].getPrice()+" Gift Type = "+gift_ob[100].toString());
            log.write(date.toString()+" "+name+" sent gift to "+ob.name+": Gift price = "+gift_ob[100].getPrice()+" Gift Type = "+gift_ob[100].toString()+System.lineSeparator());
            while(ob.m_cost>money_spent){
                x=101;
                System.out.println(name+" sent gift to "+ob.name+": Gift price = "+gift_ob[x].getPrice()+" Gift Type = "+gift_ob[x].toString());
                log.write(date.toString()+" "+name+" sent gift to "+ob.name+": Gift price = "+gift_ob[x].getPrice()+" Gift Type = "+gift_ob[x].toString()+System.lineSeparator());
                money_spent+=gift_ob[x].getPrice();
                x++;
            }
        }
    /**
     * Method to calculate happiness of GeekBoy
     * Overrides parent class method.
     * @param gf Girl object (Girlfriend of Boy)
     */
    public void calcHappiness(Girl gf){
        happiness=gf.i_level;
    }
        
}
