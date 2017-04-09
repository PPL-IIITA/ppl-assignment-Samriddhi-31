package PPL_8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Solution to Q8.
 *<br> Contains main() method which instantiates objects of TestUtility and VirtualWorld and generates required solution through method calls.
 * <br>Choice is generated at random. <br>Choice: "1" Use Gifting Algorithm One <br>        "2" Use Gifting Algorithm Two <br>        "default" Use Gifting Algorithm Two
 */
public class LIT2015021_Q8 {
    /**
     * main method to generate solution of given problem. 
     *  value of k is set to 5.
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException{
        
         Random r=new Random(); 
        int k=r.nextInt(12)+1;
        if(k>12)
        k=12;
         
        int ch=r.nextInt(3);
        
        BufferedWriter log=new BufferedWriter(new FileWriter("log.txt"));
        
        TestUtility ob=new TestUtility();
        ob.generateRandom();
        VirtualWorld v=new VirtualWorld();
        
        v.makeMatches(log);
        v.displayMatches();
        
        v.performGifting(log,ch);
        v.getCoupleStats(k);
        
        
        
        log.close();
    }
    
}
