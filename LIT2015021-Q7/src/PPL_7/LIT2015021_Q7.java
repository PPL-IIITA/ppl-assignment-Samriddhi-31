package PPL_7;

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
 * Solution to Q7.
 *<br> Contains main() method which instantiates objects of TestUtility and VirtualWorld and generates required solution through method calls.
 *<br>Choice is generated randomly. <br>"1" Unsorted Array <br>"2" Sorted Array(Binary Search) <br>"3" Hash Table <br>"default" Hash Table.
 */
public class LIT2015021_Q7 {
    /**
     * main method to generate solution of given problem.
     * 
     * @throws IOException 
     */
    public static void main(String args[]) throws IOException{
        BufferedWriter log=new BufferedWriter(new FileWriter("log.txt"));
         Random r=new Random(); 
        int choice=r.nextInt(4);
        
        
        TestUtility ob=new TestUtility();
        ob.generateRandom();
        VirtualWorld v=new VirtualWorld();
        
        v.makeMatches(log);
        v.displayMatches();
        
        v.findGirlfriendName(choice);
        
        log.close();
    }
    
}
