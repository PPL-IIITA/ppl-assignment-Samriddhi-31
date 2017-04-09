/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_8;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 *Abstract class which is base class of GiftSelectorOne and GiftSelectorTwo. 
 */
public abstract class GiftSelector {
     /**
     * Abstract Method defined in child classes to implement the respective gifting algorithms specified in problem statement.
     * @param couple_ob List of couples
     * @param gift_ob List of gifts
     * @param log a BufferedWriter
     * @throws IOException 
     */
    public abstract void selectGifts(Couple couple_ob[],Gift gift_ob[],BufferedWriter log) throws IOException;
    
}
