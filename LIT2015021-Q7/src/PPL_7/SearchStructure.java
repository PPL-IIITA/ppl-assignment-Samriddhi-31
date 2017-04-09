/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_7;

/**
 *
 * Abstract class which is base class of UnsortedSearch, BinarySearch and HashSearch.
 * Instance variable is an array of type TableEntry which will store names of commited boys and their girlfriends.
 */
public abstract class SearchStructure {
    final int size=12;
    TableEntry[] table=new TableEntry[size];
    /**
     * Abstract method implemented by child classes to store names of commited boys and their girlfriends.
     * @param a name of boy
     * @param b name of girlfriend
     */
    public abstract void storeData(String a, String b);
    /**
     * Abstract method implemented by child classes to search for specific boy's name.
     * @param a name of boy whose girlfriend's name is to be returned
     * @return name of girlfriend
     */
     public abstract String search(String a);
}
