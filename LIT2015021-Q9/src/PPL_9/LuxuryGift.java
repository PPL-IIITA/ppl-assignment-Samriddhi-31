package PPL_9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

/**
 * Class that defines the attributes of Virtual World Luxury Gift.
 * 
 */
public class LuxuryGift extends Gift{
    int lux_rate,diff;

    public LuxuryGift(int a, int b){
        super(a,b);
    }
    public String toString(){
        return "Luxury";
    }
}
