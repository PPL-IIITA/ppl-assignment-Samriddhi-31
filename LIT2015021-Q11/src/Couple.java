

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

/**
 *
 * Class that defines the attributes of Virtual World Couple.
 */
public class Couple {
    Girl gf;
    Boy bf;
    double happiness,compat;
    /**
     * Simulates the activity of forming a relationship.
     * @param g Girl object to be committed
     * @param b Boy object to be committed
     */
    public void getCommitted(Girl g, Boy b){
        gf=g;
        bf=b;
        gf.bf=b.name;
        bf.gf=g.name;
    }
    /**
     * Calculates happiness of Couple
     */
    public void calcHappiness(){
        happiness=bf.happiness+gf.happiness;
    }
    /**
     * Calculates compatibility of Couple
     */
    public void calcCompatibility(){
        compat=Math.abs(bf.budget-gf.m_cost)+Math.abs(bf.i_level-gf.i_level)+Math.abs(bf.attr-gf.attr);
    
    }
    
}
