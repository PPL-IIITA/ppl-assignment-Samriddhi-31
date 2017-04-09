//package PPL_10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

/**
 * Class that defines the attributes of and simulates Virtual World Normal Girl.
 * Child class of abstract class Girl.
 * Implements the abstract methods of parent class Girl.
 * 
 */

public class NormalGirl extends Girl {
    /**
     * Constructor to initialize the attributes of NormalGirl.
     * Includes call to super class constructor.
     * @param a name of Girl
     * @param b attractiveness of Girl
     * @param c intelligence level of Girl
     * @param d maintenance of Girl
     * @param e criteria of Girl
     */
    public NormalGirl(String a,int b,int c, int d,int e){
        super(a,b,c,d,e);
    }
    /**
     * Method to calculate happiness of ChoosyGirl
     * Overrides parent class method.
     * @param received_val Total value of received gifts
     */
    public void calcHappiness(int received_val){
        happiness=(received_val-m_cost);

    }
    
}
