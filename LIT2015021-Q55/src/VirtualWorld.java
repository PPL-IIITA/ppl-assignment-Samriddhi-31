/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package PPL_3;

import java.io.*;
import java.util.*;

/**
 * <h1>This class simulates the Virtual World in which there exist some girls, boys, couples and a variety of gifts.</h1>
 * <p>Arrays of objects of type Girl, Boy,Gift and Couple are included as instance variables.
 * <p>Class responsibility is to simulate real world activities like match-making and gifting through the member functions.
 * 
 * 
 */
public class VirtualWorld {
    
    Girl[] girl_ob; 
    Boy[] boy_ob;
    Gift[] gift_ob;
    Couple[] couple_ob;
    /** 
     * Constructor instantiates the instance variables(Arrays of different types of objects) with data generated by Testing Utility.
      * @throws FileNotFoundException if file does not exist
      * @throws IOException  if there is a problem reading a record from the file.
     * 
     */
    public VirtualWorld()throws FileNotFoundException, IOException{
        girl_ob=new Girl[12];
        boy_ob=new Boy[58];
        gift_ob = new Gift[150];
        couple_ob=new Couple[12];
        int i=0;
        String line="";
        BufferedReader br1=new BufferedReader(new FileReader("rand_girls.txt"));
        BufferedReader br2=new BufferedReader(new FileReader("rand_boys.txt"));
        BufferedReader br3=new BufferedReader(new FileReader("rand_gifts.txt"));
        while((line=br1.readLine())!=null){
           String []arr=line.split(",");  
           if(Integer.parseInt(arr[5])==0){
               girl_ob[i]=new ChoosyGirl(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
           
           }
           
           else if(Integer.parseInt(arr[5])==1)
           {
               girl_ob[i]=new NormalGirl(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
           
           }
           else if(Integer.parseInt(arr[5])==2)
           {
               girl_ob[i]=new DesperateGirl(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
           
           }
           i++;
               
                
           
       }
        i=0;
       while((line=br2.readLine())!=null){
           String []arr=line.split(",");  
           if(Integer.parseInt(arr[5])==0){
               boy_ob[i]=new Miser(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
           
           }
           
           else if(Integer.parseInt(arr[5])==1)
           {
               boy_ob[i]=new Geek(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
           
           }
           else if(Integer.parseInt(arr[5])==2)
           {
               boy_ob[i]=new GenerousBoy(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
           
           }
           i++;
               
                
           
       }
       
       for(i=0;i<50;i++){
           line=br3.readLine();
           String []arr=line.split(",");
       
           gift_ob[i]=new EssentialGift(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
       }
        for(;i<100;i++){
           line=br3.readLine();
           String []arr=line.split(",");
           gift_ob[i]=new UtilityGift(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
        }
         for(;i<150;i++){
           line=br3.readLine();
           String []arr=line.split(",");
           gift_ob[i]=new LuxuryGift(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
         }
         for(i=0; i<couple_ob.length; i++) {
           couple_ob[i]=new Couple();
           
       }
    }
    
    public void sortGirlsByCost(){
        for(int i=1;i<girl_ob.length;i++){
            for(int j=0;j<girl_ob.length-i;j++){
                if(girl_ob[j].m_cost>girl_ob[j+1].m_cost){
                    Girl ob=girl_ob[j];
                     
                    girl_ob[j]=girl_ob[j+1];
                    girl_ob[j+1]=ob;
                }
            }
        }
    }
    public void sortBoysByAttractiveness(){
        for(int i=1;i<boy_ob.length;i++){
            for(int j=0;j<boy_ob.length-i;j++){
                if(boy_ob[j].attr>boy_ob[j+1].attr){
                    Boy ob=boy_ob[j];
                     
                    boy_ob[j]=boy_ob[j+1];
                    boy_ob[j+1]=ob;
                }
            }
        }
    }
    /**
     * Method to allocate boyfriend to each girl according to her criteria: 0-"most rich" 1-"most intelligent" 2-"most attractive"
     * and most attractive available girl as girlfriend to each boy alternately. 
     */    
     public void makeMatches(BufferedWriter log) throws IOException{
        Date date=new Date();
        int i,x,y;
        int size=boy_ob.length;
        int intel[]=new int[size],rich[]=new int[size],attr[]=new int[size];
        for(i=0;i<boy_ob.length;i++){
           
            intel[i]=i;
            rich[i]=i;
            attr[i]=i;
        }
        sortGirlsByCost();
        sortBoysByAttractiveness();
        int m=0,n=0;
        outer:
        for(i=0;i<girl_ob.length;i++){
            if(i%2==0){
                while(girl_ob[m].bf!=null){
                    m++;
                    if(m>=girl_ob.length)
                        continue outer;
                }
        
           
            if(girl_ob[m].criteria==0){
                x=selectMostRich(girl_ob[m]);
            }
            else if(girl_ob[m].criteria==1){
                x=selectMostIntel(girl_ob[m]);
            }
            else{
                x=selectMostAttr(girl_ob[m]);
            }
            girl_ob[m].bf=boy_ob[x].name;
            boy_ob[x].gf=girl_ob[m].name;
            couple_ob[i].getCommitted(girl_ob[m], boy_ob[x]);
            log.write(System.lineSeparator());
            log.write(date.toString()+" "+couple_ob[i].gf.name+" commited to "+couple_ob[i].bf.name+System.lineSeparator());
            m++;
        }
            else{
                 while(boy_ob[n].gf!=null){
                    n++;
                    if(n>=boy_ob.length)
                        continue outer;
                }
                y=selectMostAttrGirl(boy_ob[n]);
                girl_ob[y].bf=boy_ob[n].name;
            boy_ob[n].gf=girl_ob[y].name;
            couple_ob[i].getCommitted(girl_ob[y], boy_ob[n]);
            log.write(System.lineSeparator());
            log.write(date.toString()+" "+couple_ob[i].gf.name+" commited to "+couple_ob[i].bf.name+System.lineSeparator());
            n++;
            }
        }
    }
    /**
     * Method to display the couples formed.
     */
    public void displayMatches(){
        System.out.println("Couples Formed:"+System.lineSeparator());
        for(int i=0;i<couple_ob.length;i++){
            System.out.println(girl_ob[i].name+" "+girl_ob[i].bf+System.lineSeparator());
        }
    }
    
    public void logCouples(BufferedWriter log) throws IOException{
        Date date=new Date();
        for(int i=0;i<couple_ob.length;i++){
            
             log.write(System.lineSeparator());
             log.write(date.toString()+" "+couple_ob[i].gf.name+" commited to "+couple_ob[i].bf.name+System.lineSeparator());
         }
    }
    int selectMostRich(Girl g){
        int i,max=0,max_b=0;
        for(i=0;i<boy_ob.length;i++){
            if(boy_ob[i].budget>max_b && boy_ob[i].min_attr<=g.attr && boy_ob[i].budget>=g.m_cost && boy_ob[i].gf==null){
                max_b=boy_ob[i].budget;
                max=i;
            }
        }
        
        return max;
    }
        int selectMostAttr(Girl g){
        int i,max=0,max_a=-1;
        for(i=0;i<boy_ob.length;i++){
            if(boy_ob[i].attr>max_a && boy_ob[i].min_attr<=g.attr && boy_ob[i].budget>=g.m_cost && boy_ob[i].gf==null){
                max_a=boy_ob[i].attr;
                max=i;
            }
        }
       
        return max;    
        }
        int selectMostIntel(Girl g){
        int i,max=0,max_i=-1;
        for(i=0;i<boy_ob.length;i++){
            if(boy_ob[i].i_level>max_i && boy_ob[i].min_attr<=g.attr && boy_ob[i].budget>=g.m_cost && boy_ob[i].gf==null){
                max_i=boy_ob[i].i_level;
                max=i;
            }
        }
       
        return max;
        }
        int selectMostAttrGirl(Boy b){
            int i,max=0,max_a=-1;
        for(i=0;i<girl_ob.length;i++){
            if(girl_ob[i].attr>max_a && b.min_attr<=girl_ob[i].attr && b.budget>=girl_ob[i].m_cost && girl_ob[i].bf==null){
                max_a=girl_ob[i].attr;
                max=i;
            }
            
        }
        return max;
    }
    void sortGiftsByPrice(){
        
        int i,j;
        for(i=1;i<150;i++){
            for(j=0;j<150-i;j++)
                if(gift_ob[j].getPrice()>gift_ob[j+1].getPrice()){
                    Gift ob=gift_ob[j];
                    gift_ob[j]=gift_ob[j+1];
                    gift_ob[j+1]=ob;
                }
                else if(gift_ob[j].getPrice()==gift_ob[j+1].getPrice() && gift_ob[j].getVal()>gift_ob[j+1].getVal()){
                    Gift ob=gift_ob[j];
                    gift_ob[j]=gift_ob[j+1];
                    gift_ob[j+1]=ob;
                } 
        }
   
    }
    /**
     * Method that simulates gift exchanges between couples and logs them in text file "log.txt".
     * Each gift basket is set according to the type of boy: 0-"miser" 1-"geek" 2-"generous".
     * makes use of methods defined in class GiftSelectorOne.
     * miser always gives cheapest priced gift available till maintenance cost of girl is satisfied
     * geek gives gifts starting from cheapest till maintenance cost of girl is satisfied plus one luxury gift if budget allows
     * generous gives maximum cost gifts within their budget
     * @param log a BufferedWriter
     * @throws IOException  if there is an error while reading/writing file
     */
        public void performGifting(BufferedWriter log) throws IOException{
            sortGiftsByPrice();
            
            GiftSelectorOne ob1;
            
            ob1=new GiftSelectorOne();
            
            ob1.selectGifts(couple_ob,gift_ob,log);
        }
        /**
         * Method to get the happiness and compatibility of each couple.
         * Calls the methods defined in class Stats
         * @param k variable defined in problem statement
         */
        public void getCoupleStats(int k){
            Stats s=new Stats();
            for(int i=0;i<couple_ob.length;i++){
                couple_ob[i].gf.calcHappiness(couple_ob[i].bf.money_spent);
                couple_ob[i].bf.calcHappiness(couple_ob[i].gf);
                couple_ob[i].calcHappiness();
                couple_ob[i].calcCompatibility();
            }
            s.sortCouplesByHappiness(couple_ob);
            s.printKHappiest(couple_ob,k );
            System.out.println();
            s.sortCouplesByCompatibility(couple_ob);
            s.printKCompatible(couple_ob, k);
        }
       
        
    }
