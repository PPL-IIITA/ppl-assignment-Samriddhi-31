/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_2;
import java.math.*;
/**
 * <h1>Class that calculates relationship statistics.</h1>
 * Class responsibility is to compute and print required data about couples according to problem statement.
 * 
 */
public class Stats {
    /**
     * Method to compute the happiness and compatibility of each couple.
     * @param c Array of objects of class Couple
     */
    public void calcHappiness(Couple c[]){
        for(int i=0;i<c.length;i++){
        if(c[i].gf.type==0){
            c[i].gf.happiness=Math.log(c[i].bf.money_spent-c[i].gf.m_cost);
        }
        else if(c[i].gf.type==1){
            c[i].gf.happiness=(c[i].bf.money_spent-c[i].gf.m_cost);
        }
        else{
            c[i].gf.happiness=Math.exp(c[i].bf.money_spent-c[i].gf.m_cost);
        }
        if(c[i].bf.type==0){
            c[i].bf.happiness=c[i].bf.budget-c[i].bf.money_spent;
        }
        else if(c[i].bf.type==2){
            c[i].bf.happiness=c[i].gf.happiness;
        }
        else{
            c[i].gf.happiness=c[i].gf.i_level;
        }
        c[i].happiness=c[i].bf.happiness+c[i].gf.happiness;
        c[i].compat=Math.abs(c[i].bf.budget-c[i].gf.m_cost)+Math.abs(c[i].bf.i_level-c[i].gf.i_level)+Math.abs(c[i].bf.attr-c[i].gf.attr);
    }
      for(int i=0;i<c.length;i++){
            //System.out.println(c[i].bf.happiness+" "+c[i].gf.happiness+" "+c[i].happiness+" "+c[i].compat);  
      }
    }
    /**
     * Method to print k happiest couples.
     * @param c array of objects of class Couple
     * @param k best k happiest couples
     */
    public void printKHappiest(Couple c[],int k){
        
        for(int i=1;i<c.length;i++){
            for(int j=0;j<c.length-i;j++){
                if(c[j].happiness<c[j+1].happiness){
                    Couple ob=c[j];
                    c[j]=c[j+1];
                    c[j+1]=ob;
                }
            }
        }
        System.out.println();
        System.out.println("The "+k+" Happiest Couples are: ");
        for(int i=0;i<k;i++){
            System.out.println(c[i].gf.name+" "+c[i].bf.name);
        }
        
    }
    /**
     * Method to print k most compatible couples
     * @param c array of objects of class Couple
     * @param k k most compatible couples
     */
    public void printKCompatible(Couple c[],int k){
        for(int i=1;i<c.length;i++){
            for(int j=0;j<c.length-i;j++){
                if(c[j].compat<c[j+1].compat){
                    Couple ob=c[j];
                    c[j]=c[j+1];
                    c[j+1]=ob;
                }
            }
        }
        System.out.println("The "+k+" Most Compatible Couples are: ");
        for(int i=0;i<k;i++){
            System.out.println(c[i].gf.name+" "+c[i].bf.name);
        }
    }
    
}
