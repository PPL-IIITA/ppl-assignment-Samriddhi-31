/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 *  Generic Class that returns a Random item from best k valued items.
 */
public class RandomKSelector<T> {
    /**
     * returns a Random item from best k valued items
     * @param a List of best k valued items
     * @param k value of "k"
     * @return a Random item from best k valued items is returned
     */
    public T getRandomK(ArrayList<T> a,int k){
        Random r=new Random();
        int cnt=0;
        T b=null;
        int i=r.nextInt(k);
        Iterator itr=a.iterator();  
        while(itr.hasNext()){  
            b=(T)itr.next(); 
            cnt++;
            if(cnt==k)
                break;
           
        }
        return b;
    }
}
        
        
    
