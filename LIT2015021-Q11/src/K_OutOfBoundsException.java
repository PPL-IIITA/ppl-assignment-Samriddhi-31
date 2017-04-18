/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 * <h2>Exception Class for the situation when value of 'k' (generated randomly) is greater than the number of couples formed.
 * <br>Here, 'k' is the variable specified in Q2 used for calculating 'k' happiest couples and 'k' most compatible couples.
 * <br>This Exception class is for the algorithms to find 'k' happiest couples and 'k' most compatible couples.</h2>
 */
public class K_OutOfBoundsException extends Exception{
    /**
     * Constructor to print error message corresponding to the exception that has occurred.
     */
    public K_OutOfBoundsException(){ 
        System.out.println();
        System.out.println("K_OutOfBounds Exception thrown! Value of k is greater than number of couples formed. It will be set equal to number of couples formed.");
    }
    
}
