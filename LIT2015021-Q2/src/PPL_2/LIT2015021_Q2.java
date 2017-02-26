/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_2;
import java.io.*;
/**
 * Solution to Q2.
 *<br> Contains main() method which instantiates objects of TestUtility and VirtualWorld and generates required solution through method calls.
 * <br>Value of k is set to 5.
 */

public class LIT2015021_Q2 {
   
    public static void main(String args[]) throws IOException{
        BufferedWriter log=new BufferedWriter(new FileWriter("log.txt"));
        //int k=Integer.parseInt(args[0]);
        int k=5;
        TestUtility ob=new TestUtility();
        ob.generateRandom();
        VirtualWorld v=new VirtualWorld();
        v.getDataBase();
        v.makeMatches();
        v.displayMatches();
        v.logCouples(log);
        v.performGifting(log);
        v.getCoupleStats(k);
        log.close();
    }
    
}
