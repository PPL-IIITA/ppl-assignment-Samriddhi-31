/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 * <h2>Exception class for situations in which the value of a variable is invalid and needs to be reset to a valid  value.</h2>
 */
public class InvalidValueException extends Exception {
    /**
     * Constructor to print error message corresponding to the exception that has occurred.
     */
    public InvalidValueException(){ 
        System.out.println();
        System.out.println("InvalidValueException thrown! Setting variable to a valid value.");
    }
    
}
