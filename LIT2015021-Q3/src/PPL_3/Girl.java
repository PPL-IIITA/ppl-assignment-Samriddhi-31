package PPL_3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

/**
 *
 * Abstract Class that defines the attributes of Virtual World Generalized Girl.
 */
public abstract class Girl {
    String name;
    int attr;
    int i_level;
    int m_cost;
    int criteria;
    double happiness;
    String bf;
    /**
     * Constructor to initialize the attributes of Girl.
     * Includes call to super class constructor.
     * @param a name of Girl
     * @param b attractiveness of Girl
     * @param c intelligence level of Girl
     * @param d maintenance of Girl
     * @param e criteria of Girl
     */
    public Girl(String a,int b,int c, int d,int e){
        name=a;
        attr=b;
        i_level=c;
        m_cost=d;
        criteria=e;
        happiness=0;
        bf=null;
    }
    /**
     * Abstract Method to calculate happiness of Girl
     * 
     * @param received_val Total value of received gifts
     */
    public abstract void calcHappiness(int received_val);
}

