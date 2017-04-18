//package PPL_10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_4;
import java.io.*;
import java.util.*;
/**
 * This class is a dedicated Testing Utility which creates random girls, boys and gifts of every type and stores them in files "rand_girls.txt", "rand_boys.txt" and "rand_gifts.txt" respectively. 
 * 
 */
public class TestUtility {
    /**
     * Method to generate random girls, boys, gifts and their attributes and write them to text files.
     * @throws IOException if there is an error while reading/writing file
     */
    public void generateRandom() throws IOException{
      BufferedWriter bw = new BufferedWriter(new FileWriter("rand_girls.txt"));
      BufferedWriter bw2 = new BufferedWriter(new FileWriter("rand_boys.txt"));
      Random r = new Random();
      int i;
      int a[]=new int[12];
      String s[]=new String[12],line;
      BufferedReader br1=new BufferedReader(new FileReader("girl_names.txt"));
       i=0;
      for(i=0;i<12;i++)
      {
                 
         bw.write(br1.readLine()+",");
         bw.write(String.valueOf(r.nextInt(10)+2)+",");
         bw.write(r.nextInt(10)+",");
         bw.write((r.nextInt(1000)+1000)+",");
        
     bw.write(r.nextInt(3)+",");
     bw.write(r.nextInt(3)+System.lineSeparator());
         
      }
      bw.write("-1");
        BufferedReader br2=new BufferedReader(new FileReader("boy_names.txt"));
       i=0;
     int range=3000,l=2000;
       for(i=0;i<58;i++)
      {
          
           bw2.write(br2.readLine()+",");
         bw2.write(String.valueOf(r.nextInt(10))+",");
     bw2.write(r.nextInt(10)+",");
     if(i<20)
         bw2.write(500+",");
     else
     bw2.write((r.nextInt(range)+l)+",");
        
     bw2.write(r.nextInt(3)+",");
     bw2.write(r.nextInt(3)+System.lineSeparator());
      }
       bw2.write("-1");
    bw2.close();
     
    bw.close();
    
        bw = new BufferedWriter(new FileWriter("rand_gifts.txt"));
       
        for(i=0;i<50;i++){
           
            bw.write((r.nextInt(200)+100)+","+(r.nextInt(100)+100)+System.lineSeparator());
        }
        for(i=0;i<50;i++){
            
             bw.write((r.nextInt(300)+100)+","+(r.nextInt(100)+100)+","+(r.nextInt(100)+100)+System.lineSeparator());
        }
        for(i=0;i<50;i++){
            
            bw.write((r.nextInt(100)+400)+","+(r.nextInt(100)+100)+","+(r.nextInt(100)+100)+System.lineSeparator());
        
        }
        bw.write("-1");
        bw.close();
    }
   
     
        
}
    

