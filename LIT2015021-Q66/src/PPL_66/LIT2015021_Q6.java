package PPL_66;

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
 * Solution to Q6.
 *<br> Contains main() method which instantiates objects of TestUtility and VirtualWorld and generates required solution through method calls.
 * <br>Value of t is generated randomly between 1 and 30.
 */
public class LIT2015021_Q6 {
    /**
     * main method to generate solution of given problem.
     * 
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException{
        BufferedWriter log=new BufferedWriter(new FileWriter("log.txt"));
        Random r=new Random();
        
        int t=r.nextInt(30)+1;
        
        TestUtility ob=new TestUtility();
        ob.generateRandom();
        VirtualWorld v=new VirtualWorld();
        
        v.makeMatches(log);
        v.displayMatches();
        
        for(int i=0;i<t;i++){
        
       System.out.println("DAY "+(i+1));
        v.performGifting(log);
        //v.getCoupleStats(k); 
        v.performBreakUp(t, log);
        System.out.println();
        v.displayMatches();
         
        }
        log.close();
    }
    
}
