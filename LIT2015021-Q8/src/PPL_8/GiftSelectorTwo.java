/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Class that defines the second Gift Selection Algorithm( specified in problem statement).
 * Child class of class GiftSelector
 */
public class GiftSelectorTwo extends GiftSelector{
    /**
     * Selects one EssentialGift for gift basket
     * @param couple_ob Couple object
     * @param gift_ob list of gifts
     * @param log   a BufferedWriter
     * @throws IOException 
     */
    void giftEssentialGift(Couple couple_ob,Gift gift_ob[],BufferedWriter log) throws IOException{
        Date date = new Date();
        for(int i=0;i<gift_ob.length;i++){
            if(gift_ob[i].toString().equals("Essential")){
                System.out.println(couple_ob.bf.name+" sent gift to "+couple_ob.gf.name+": Gift price = "+gift_ob[i].getPrice()+" Gift Type = "+gift_ob[i].toString());
                log.write(date.toString()+" "+couple_ob.bf.name+" sent gift to "+couple_ob.gf.name+": Gift price = "+gift_ob[i].getPrice()+" Gift Type = "+gift_ob[i].toString()+System.lineSeparator());
               
                
                couple_ob.bf.money_spent+=gift_ob[i].getPrice();
                return;
            }
        }
        
    }
    /**
     * Selects one UtilityGift for gift basket
     * @param couple_ob Couple object
     * @param gift_ob list of gifts
     * @param log   a BufferedWriter
     * @throws IOException 
     */
     void giftUtilityGift(Couple couple_ob,Gift gift_ob[],BufferedWriter log) throws IOException{
        Date date = new Date();
        for(int i=0;i<gift_ob.length;i++){
            if(gift_ob[i].toString().equals("Utility")){
                System.out.println(couple_ob.bf.name+" sent gift to "+couple_ob.gf.name+": Gift price = "+gift_ob[i].getPrice()+" Gift Type = "+gift_ob[i].toString());
                log.write(date.toString()+" "+couple_ob.bf.name+" sent gift to "+couple_ob.gf.name+": Gift price = "+gift_ob[i].getPrice()+" Gift Type = "+gift_ob[i].toString()+System.lineSeparator());
               
                
                couple_ob.bf.money_spent+=gift_ob[i].getPrice();
                return;
            }
        }
        
    }
     /**
     * Selects one LuxuryGift for gift basket
     * @param couple_ob Couple object
     * @param gift_ob list of gifts
     * @param log   a BufferedWriter
     * @throws IOException 
     */
      void giftLuxuryGift(Couple couple_ob,Gift gift_ob[],BufferedWriter log) throws IOException{
        Date date = new Date();
        for(int i=0;i<gift_ob.length;i++){
            if(gift_ob[i].toString().equals("Luxury")){
                System.out.println(couple_ob.bf.name+" sent gift to "+couple_ob.gf.name+": Gift price = "+gift_ob[i].getPrice()+" Gift Type = "+gift_ob[i].toString());
                log.write(date.toString()+" "+couple_ob.bf.name+" sent gift to "+couple_ob.gf.name+": Gift price = "+gift_ob[i].getPrice()+" Gift Type = "+gift_ob[i].toString()+System.lineSeparator());
               
                
                couple_ob.bf.money_spent+=gift_ob[i].getPrice();
                return;
            }
        }
        
    }
    /**
     * Method that implements the second gifting algorithm specified in problem statement.
     * @param couple_ob List of couples
     * @param gift_ob List of gifts
     * @param log a BufferedWriter
     * @throws IOException 
     */
    public void selectGifts(Couple[] couple_ob, Gift[] gift_ob, BufferedWriter log) throws IOException{
        System.out.println("USING GIFTING ALGORITHM TWO");
        log.write(System.lineSeparator());
        log.write("USING GIFTING ALGORITHM TWO"+System.lineSeparator());
        log.write(System.lineSeparator());
        System.out.println("GIFTING DETAILS:"+System.lineSeparator());
            int price,val;
            for (Couple couple_ob1 : couple_ob) {
                try {
                log.write(System.lineSeparator());
            } catch (IOException ex) {
                Logger.getLogger(GiftSelectorTwo.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println();
                couple_ob1.bf.money_spent=0;
                giftEssentialGift(couple_ob1,gift_ob,log);
                giftUtilityGift(couple_ob1,gift_ob,log);
                giftLuxuryGift(couple_ob1,gift_ob,log);
           
                couple_ob1.bf.selectGifts(couple_ob1.gf,gift_ob,log);  //better design : couple_ob1.buildGiftBasket(gift_ob,log);
                System.out.println("Total cost of gifts = "+couple_ob1.bf.money_spent);
                log.write("Total cost of gifts = "+couple_ob1.bf.money_spent+System.lineSeparator());
            }
    }
    
}
