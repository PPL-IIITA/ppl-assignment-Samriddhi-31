package PPL_7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_4;

/**
 * Class that defines the attributes of Virtual World Utility Gift.
 * 
 */
public class UtilityGift extends Gift{
    int u_val,u_class;
    public UtilityGift(int a, int b){
        super(a,b);
    }
    @Override
    public String toString(){
        return "Utility";
    }
    
}
