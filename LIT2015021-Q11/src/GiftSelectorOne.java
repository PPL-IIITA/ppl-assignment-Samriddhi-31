/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_44;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * Class that defines the Gift Selection Algorithm.
 * 
 */
public class GiftSelectorOne {

    /**
     * Method that implements the gifting algorithm.
     * @param couple_ob List of couples
     * @param gift_ob List of gifts
     * @param log a BufferedWriter
     * @throws IOException 
     */
    
    public void selectGifts(Couple couple_ob[],Gift gift_ob[],BufferedWriter log) throws IOException{
        System.out.println("GIFTING DETAILS:"+System.lineSeparator());
            
            for (Couple couple_ob1 : couple_ob) {
                couple_ob1.bf.money_spent=0;
            try {
                log.write(System.lineSeparator());
            } catch (IOException ex) {
                Logger.getLogger(GiftSelectorOne.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println();
                couple_ob1.bf.selectGifts(couple_ob1.gf,gift_ob,log);  //better design : couple_ob1.buildGiftBasket(gift_ob,log);
                System.out.println("Total cost of gifts = "+couple_ob1.bf.money_spent);
                log.write("Total cost of gifts = "+couple_ob1.bf.money_spent+System.lineSeparator());
            }
    }
}
