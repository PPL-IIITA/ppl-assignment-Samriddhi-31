package PPL_10;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * Generic Class that returns the best k valued items.
 */
public class BestKSelector<T> {
    /**
     * Finds best "k" valued items trough sorting.
     * @param arr List of items of generic type T.
     * @param val Criteria according to which best k valued items are to be found.
     * @param flagged indicates whether an item has been flagged.
     */
    void sortGeneric(T[] arr,int[] val,int[] flagged){
        for(int i=1;i<arr.length;i++){
             for(int j=0;j<arr.length-i;j++){
                 if(val[j]<val[j+1]){
                     int t=val[j];
                     val[j]=val[j+1];
                     val[j+1]=t;
                     t=flagged[j];
                     flagged[j]=flagged[j+1];
                     flagged[j+1]=t;
                     T temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                 }
             }
         }
    }
    /**
     * Method to return the best "k" valued items from given list of items of generic type T.
     * @param arr List of items of generic type T.
     * @param val Criteria according to which best k valued items are to be found.
     * @param flagged indicates whether an item has been flagged.
     * @param k value of "k"
     * @return ArrayList (of type T) containing best k valued items is returned.
     */
    public ArrayList<T> getBestK(T[] arr,int[] val,int[] flagged,int k){
         ArrayList<T> a = new ArrayList();
         //System.out.println("hello");
         for(int i=1;i<arr.length;i++){
             for(int j=0;j<arr.length-i;j++){
                 if(val[j]<val[j+1]){
                     int t=val[j];
                     val[j]=val[j+1];
                     val[j+1]=t;
                     t=flagged[j];
                     flagged[j]=flagged[j+1];
                     flagged[j+1]=t;
                     T temp=arr[j];
                     arr[j]=arr[j+1];
                     arr[j+1]=temp;
                 }
             }
         }
         int cnt=0;
         for(int i=0;i<arr.length;i++){
             if(flagged[i]==0 ){
                 a.add(arr[i]);
                 cnt++;
                 if(cnt==k)
                     break;
             }
             
         }
        
      return a;  
    }
    
}
