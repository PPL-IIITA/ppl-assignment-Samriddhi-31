/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 * <h2>Exception Class for situations in which end of input data from file is reached ,that is, "-1" is read from file.
 * <br>This indicates that there is no more data to be read from file.</h2>
 */
public class EndOfInputException extends Exception{
    public EndOfInputException(){
        /**
         * Constructor to print error message corresponding to the exception that has occurred.
         */
        System.out.println("EndOfInputException thrown! End of Input Reached");
    }
    
}
