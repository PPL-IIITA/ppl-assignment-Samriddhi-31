/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_7;

/**
 *
 *Class that implements variant TWO , that is, sorted array(Binary Search ) specified in problem statement.
 *Child class of SearchStructure.
 */
public class BinarySearch  extends SearchStructure{
    static int i=0;
    /**
     * Constructor to instantiate the array of type TableEntry which will store names of commited boys and their girlfriends.
     */
    public BinarySearch(){
        for(int i=0;i<size;i++){
            table[i]=new TableEntry();
        }
    }
    /**
     * 
     * method to store names of commited boys and their girlfriends.
     * overrides base class method
     * @param boy_name name of boy
     * @param girl_name name of girlfriend
     
     */
     public void storeData(String boy_name,String girl_name){
         table[i].bf_name=boy_name;
                  table[i].gf_name=girl_name;
                  i++;
                  if(i==size){
                      sortNames();
                  }
     }
     public void sortNames(){
         for(int i=1;i<size;i++){
             for(int j=0;j<size-i;j++){
                 if(table[j].bf_name.compareTo(table[j+1].bf_name)>0){
                     TableEntry x=table[j];
                     table[j]=table[j+1];
                     table[j+1]=x;
                 }
             }
         }
     }
     /**
      * performs binary search on sorted array.
      * @param value name of boy
      * @return girlfriend's name 
      */
     public String search(String value){
         int start=0,end=size-1,ans=-1;
         while (start <= end) {
            int mid = (start + end) / 2;
            if (value.equals(table[mid].bf_name)) {
                return table[mid].gf_name;
                //break;
            }
            if (value.compareTo(table[mid].bf_name)<0) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }
         return null;
     }
}
