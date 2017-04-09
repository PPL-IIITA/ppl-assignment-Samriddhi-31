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
 *
 * 
 * Solution to Q5.
 *<br> Contains main() method which instantiates objects of TestUtility and VirtualWorld and generates required solution through method calls.
 * <br>Value of k is generated at random. If k is greater than (no. of couples) then k will be set to no. of couples formed.
 */
 
public class LIT2015021_Q5 {
    /**
     * main method to generate solution of given problem.
     * 
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException{
        BufferedWriter log=new BufferedWriter(new FileWriter("log.txt"));
        Random r=new Random(); 
        int k=r.nextInt(12)+1;
        if(k>12)
        k=12;
        TestUtility ob=new TestUtility();
        ob.generateRandom();
        VirtualWorld v=new VirtualWorld();
        
        v.makeMatches(log);
        v.displayMatches();
        
        v.performGifting(log);
        v.getCoupleStats(k);
        
        log.close();
    }
    
}
