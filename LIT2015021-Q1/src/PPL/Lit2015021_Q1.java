/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL;
import java.io.*;
import java.io.IOException;

/**
 * Implements solution to Q1.
 * Contains main() method which instantiates objects of TestUtility and VirtualWorld and generates required solution through method calls.
 */

public class Lit2015021_Q1 {
   
    public static void main(String args[]) throws IOException{
        TestUtility ob=new TestUtility();
        ob.generateRandom();
        VirtualWorld v=new VirtualWorld();
        v.getDataBase();
        v.makeMatches();
        v.displayMatches();
    }
    
}
