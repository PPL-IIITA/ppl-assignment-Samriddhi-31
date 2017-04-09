/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_10;
import java.math.*;
/**
 * 
 * Class whose responsibility is to compute and print required data about couples according to problem statement.
 * 
 */
public class Stats {
        void sortCouplesByHappiness(Couple couple_ob[]){
            for(int i=1;i<couple_ob.length;i++){
            for(int j=0;j<couple_ob.length-i;j++){
                if(couple_ob[j].happiness<couple_ob[j+1].happiness){
                    Couple ob=couple_ob[j];
                     
                    couple_ob[j]=couple_ob[j+1];
                    couple_ob[j+1]=ob;
                }
            }
        }
    }
        /**
     * Method to print k happiest couples
     * @param c array of objects of class Couple
     * @param k value of "k"
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
    void sortCouplesByCompatibility(Couple couple_ob[]){
            for(int i=1;i<couple_ob.length;i++){
            for(int j=0;j<couple_ob.length-i;j++){
                if(couple_ob[j].compat<couple_ob[j+1].compat){
                    Couple ob=couple_ob[j];
                    couple_ob[j]=couple_ob[j+1];
                    couple_ob[j+1]=ob;
                }
            }
        }
        }
    /**
     * Method to print k most compatible couples
     * @param c array of objects of class Couple
     * @param k value of "k"
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
