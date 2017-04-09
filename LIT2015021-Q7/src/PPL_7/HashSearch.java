/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_7;

/**
 *
 * Class that implements variant THREE , that is, hash table specified in problem statement.
 * Child class of SearchStructure.
 */
public class HashSearch extends SearchStructure{
    /**
     * Constructor to initialize hash table which will store names of commited boys and their girlfriends
     * with null values.
     */
    public HashSearch(){
        for(int i=0;i<size;i++){
            table[i]=null;
            
        }
    }
    /**
     * method to calculate hash value.
     * @param value value whose hash value is to be calculated
     * @return hash value
     */
    int hash(String value){
        
            int length = value.length();
            int hh=rec(length);
            int i, sum;
            for (sum=0, i=0; i < length; i++)
            sum += value.charAt(i);
            return sum;
      }
       int rec(int n){
           if(n==1)
               return n;
           
            return n*rec(n-1);
           
       } 
    /**
     * 
     * method store names of commited boys and their girlfriendsin hash table.
     * overrides base class method
     * @param boy_name name of boy
     * @param girl_name name of girlfriend
     
     */
    public void storeData(String boy_name,String girl_name){
        int h=hash(boy_name)%size;
       
        while (table[h] != null)
                  h = (h + 1) % size;
            table[h] = new TableEntry();
            table[h].bf_name=boy_name;
            table[h].gf_name=girl_name;
             table[h].init(boy_name,girl_name);
            
    }
    /**
      * performs search on hash table.
      * @param value name of boy
      * @return girlfriend's name 
      */
    public String search(String value){
        int h=hash(value)%size;
       for(int i=0;i<size;i++){
            h = (h + i) % size;
            if((table[h].bf_name).equals(value)==true)
                 
            
        
            return table[h].gf_name;
        }
       return null;
    }
}