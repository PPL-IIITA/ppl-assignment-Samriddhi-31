package PPL_8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_4;

/**
 * Abstract Class that defines the attributes of Virtual World Generalized Gift.
 * 
 */
public abstract class Gift {
    private final int price;
    private final int val;
    boolean gifted;
    /**
     * Consructor to initialize attributes of Gift object.
     * @param a price
     * @param b value
     */
    public Gift(int a,int b){
        price=a;
        val=b;
        gifted=false;
    }
    /**
     * Getter method for value of Gift
     * @return returns value of Gift object
     */
    public int getVal(){
        return val;
    }
    /**
     * Getter method for price of Gift
     * @return returns price of Gift object
     */
    public int getPrice(){
        return price;
    }
}
