/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 
 * <h2>Exception class for situations in which an invalid couple is formed, that is, the budget of the boy is less than the maintenance cost of the girl.This Exception class is for the algorithm "makeMatches()" defined in class VirtualWorld_WithExceptions that forms couples.</h2>
 */
public class InvalidCoupleFormedException extends Exception{
    /**
     * Constructor to print error message corresponding to the exception that has occurred.
     */
    public InvalidCoupleFormedException(){
        System.out.println("InvalidCoupleFormedException thrown! The couple formed is not valid.");
    }
    
}
