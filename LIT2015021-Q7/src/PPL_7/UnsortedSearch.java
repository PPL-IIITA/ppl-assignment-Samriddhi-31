/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_7;

/**
 *
 * Class that implements variant One , that is, unsorted sorted array specified in problem statement.
 *Child class of SearchStructure.
 */
public class UnsortedSearch extends SearchStructure {
    static int i=0;
    /**
     * Constructor to instantiate the array of type TableEntry which will store names of commited boys and their girlfriends.
     */
    public UnsortedSearch(){
        for(int i=0;i<size;i++){
            table[i]=new TableEntry();
        }
    }
    /**
     * method to store names of commited boys and their girlfriends.
     * overrides base class method
     * @param boy_name name of boy
     * @param girl_name name of girlfriend
     */
     public void storeData(String boy_name,String girl_name){
         table[i].bf_name=boy_name;
                  table[i].gf_name=girl_name;
                  i++;
     }
     /**
      * performs linear search on unsorted array.
      * @param value name of boy
      * @return girlfriend's name 
      */
     public String search(String value){
         for(int i=0;i<size;i++){
             if(table[i].bf_name.equals(value)){
                 return table[i].gf_name;
             }
         }
         return null;
     }
    
}
