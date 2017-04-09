/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPL_2;

import java.io.*;
import java.util.*;

/**
 * <h1>This class simulates the Virtual World in which there exist some girls, boys, couples and a variety of gifts.</h1>
 * <p>Arrays of objects of type Girl, Boy, EssentialGift, UtilityGift, LuxuryGift and Couple are included as instance variables.
 * <p>Class responsibility is to simulate real world activities like match-making and gifting through the member functions.
 * 
 * 
 */
public class VirtualWorld {
    
    Girl[] girl_ob=new Girl[12];
    Boy[] boy_ob=new Boy[58];
    EssentialGift[] essgift_ob=new EssentialGift[50];
    UtilityGift[] utilgift_ob=new UtilityGift[50];
    LuxuryGift[] luxgift_ob=new LuxuryGift[50];
    Couple couple_ob[]=new Couple[12];
    /** 
     * Constructor instantiates the instance variables with default values.
     * 
     */
     public VirtualWorld(){
        int i;
       for(i=0; i<girl_ob.length; i++) {
           girl_ob[i]=new Girl();
           
       }
       for(i=0; i<boy_ob.length; i++) {
           boy_ob[i]=new Boy();
       }
       for(i=0;i<essgift_ob.length;i++)
           essgift_ob[i]=new EssentialGift();
        for(i=0;i<utilgift_ob.length;i++)
           utilgift_ob[i]=new UtilityGift();
         for(i=0;i<luxgift_ob.length;i++)
           luxgift_ob[i]=new LuxuryGift();
         for(i=0; i<couple_ob.length; i++) {
           couple_ob[i]=new Couple();
           
       }
    }
     /**
      * Method to initialize the arrays with data generated by Testing Utility
      * @throws FileNotFoundException if file does not exist
      * @throws IOException  if there is a problem reading a record from the file
      */
    public void getDataBase() throws FileNotFoundException, IOException{
        BufferedReader br1=new BufferedReader(new FileReader("rand_girls.txt"));
        BufferedReader br2=new BufferedReader(new FileReader("rand_boys.txt"));
        BufferedReader br3=new BufferedReader(new FileReader("rand_gifts.txt"));
        String line;
        int i=0;
        while((line=br1.readLine())!=null){
                 //girl_ob[i].initDetails(line);
               String []arr=line.split(",");
               
                girl_ob[i].name=arr[0];
                girl_ob[i].attr=Integer.parseInt(arr[1]);
                girl_ob[i].i_level=Integer.parseInt(arr[2]);
                girl_ob[i].m_cost=Integer.parseInt(arr[3]);
                girl_ob[i].criteria=Integer.parseInt(arr[4]);
                girl_ob[i].type=Integer.parseInt(arr[5]);
                girl_ob[i].bf=null;
                
                i++;
         
            }
        i=0;
        while((line=br2.readLine())!=null){
                //boy_ob[i].initDetails(line);
                String []arr=line.split(",");
                boy_ob[i].name=arr[0];
                boy_ob[i].attr=Integer.parseInt(arr[1]);
                boy_ob[i].i_level=Integer.parseInt(arr[2]);
                boy_ob[i].budget=Integer.parseInt(arr[3]);
                boy_ob[i].min_attr=Integer.parseInt(arr[4]);
                boy_ob[i].type=Integer.parseInt(arr[5]);
                boy_ob[i].gf=null;
                boy_ob[i].money_spent=0;
                i++;
         
            }
        int x=0;
        for(i=0;i<50;i++){
                line=br3.readLine();
                //essgift_ob_ob[i].initDetails(line);
                String []arr=line.split(",");
                essgift_ob[x].price=Integer.parseInt(arr[0]);
                essgift_ob[x].val=Integer.parseInt(arr[1]);
               
                x++;
         
            }
        
        for(i=0;i<50;i++){
                line=br3.readLine();
                //utilgift_ob[i].initDetails(line);
                String []arr=line.split(",");
                utilgift_ob[i].price=Integer.parseInt(arr[0]);
                utilgift_ob[i].val=Integer.parseInt(arr[1]);
               
                x++;
         
            }
        for(i=0;i<50;i++){
                line=br3.readLine();
                //luxgift_ob[i].initDetails(line);
                String []arr=line.split(",");
                luxgift_ob[i].price=Integer.parseInt(arr[0]);
                luxgift_ob[i].val=Integer.parseInt(arr[1]);
               
                x++;
         
            }
    }
    /**
     * Method to allocate boyfriends to each girl according to her criteria: 0-"most rich" 1-"most intelligent" 2-"most attractive".
     */    
    public void makeMatches(){
        int i,x;
        int size=boy_ob.length;
        int intel[]=new int[size],rich[]=new int[size],attr[]=new int[size];
        for(i=0;i<boy_ob.length;i++){
           
            intel[i]=i;
            rich[i]=i;
            attr[i]=i;
        }
        
        for(i=0;i<girl_ob.length;i++){
           
            if(girl_ob[i].criteria==0){
                x=selectMostRich(girl_ob[i]);
            }
            else if(girl_ob[i].criteria==1){
                x=selectMostIntel(girl_ob[i]);
            }
            else{
                x=selectMostAttr(girl_ob[i]);
            }
            girl_ob[i].bf=boy_ob[x].name;
            boy_ob[x].gf=girl_ob[i].name;
            couple_ob[i].gf=girl_ob[i];
            couple_ob[i].bf=boy_ob[x];
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
    /**
     * Method to log all commitments in text file "log.txt".
     * @param log a BufferedWriter object
     * @throws IOException if there is an error while reading/writing file
     */
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
        
    void sortGiftsByPrice(){
        int i,j;
        for(i=1;i<50;i++){
            for(j=0;j<50-i;j++)
                if(essgift_ob[j].price>essgift_ob[j+1].price){
                    EssentialGift ob=essgift_ob[j];
                    essgift_ob[j]=essgift_ob[j+1];
                    essgift_ob[j+1]=ob;
                }
                else if(essgift_ob[j].price==essgift_ob[j+1].price && essgift_ob[j].val>essgift_ob[j+1].val){
                    EssentialGift ob=essgift_ob[j];
                    essgift_ob[j]=essgift_ob[j+1];
                    essgift_ob[j+1]=ob;
                } 
        }
        for(i=1;i<50;i++){
            for(j=0;j<50-i;j++)
                if(utilgift_ob[j].price>utilgift_ob[j+1].price){
                    UtilityGift ob=utilgift_ob[j];
                    utilgift_ob[j]=utilgift_ob[j+1];
                    utilgift_ob[j+1]=ob;
                }
                else if(utilgift_ob[j].price==utilgift_ob[j+1].price && utilgift_ob[j].val>utilgift_ob[j+1].val){
                    UtilityGift ob=utilgift_ob[j];
                    utilgift_ob[j]=utilgift_ob[j+1];
                    utilgift_ob[j+1]=ob;
                } 
        }
        for(i=1;i<50;i++){
            for(j=0;j<50-i;j++)
                if(luxgift_ob[j].price>luxgift_ob[j+1].price){
                    LuxuryGift ob=luxgift_ob[j];
                    luxgift_ob[j]=luxgift_ob[j+1];
                    luxgift_ob[j+1]=ob;
                }
                else if(luxgift_ob[j].price==luxgift_ob[j+1].price && luxgift_ob[j].val>luxgift_ob[j+1].val){
                    LuxuryGift ob=luxgift_ob[j];
                    luxgift_ob[j]=luxgift_ob[j+1];
                    luxgift_ob[j+1]=ob;
                } 
        }
    }
    /**
     * Method that simulates gift exchanges between couples and logs them in text file "log.txt".
     * Each gift basket is set according to the type of boy: 0-"miser" 1-"geek" 2-"generous".
     * miser always gives cheapest priced gift available till maintenance cost of girl is satisfied
     * geek gives gifts starting from till maintenance cost of girl is satisfied plus one luxury gift if budget allows
     * generous give max cost gifts within their budget
     * @param log a BufferedWriter
     * @throws IOException  if there is an error while reading/writing file
     */
        public void performGifting(BufferedWriter log) throws IOException{
            sortGiftsByPrice();
            System.out.println("GIFTING DETAILS:"+System.lineSeparator());
            Date date=new Date();
            int price,val;
        for (Couple couple_ob1 : couple_ob) {
             log.write(System.lineSeparator());
             System.out.println();
             
            if(couple_ob1.bf.type==0){//miser always gives cheapest priced gift with cheapest value
                int x=0,y=0;
                while(couple_ob1.gf.m_cost>couple_ob1.bf.money_spent){
                    if(essgift_ob[x].price<=utilgift_ob[y].price){
                        System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+essgift_ob[x].price+" Gift Type =Essential");
                        log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+essgift_ob[x].price+" Gift Type =Essential"+System.lineSeparator());
                        
                        price=essgift_ob[x].price;
                        //val=essgift_ob[x].val;
                        x++;
                    }
                    else{
                        System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+utilgift_ob[y].price+" Gift Type = Utility");
                        log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+utilgift_ob[y].price+" Gift Type = Utility"+System.lineSeparator());
                        
                         price=utilgift_ob[y].price;
                        /// val=utilgift_ob[y].val;
                         y++;
                    }
                    couple_ob1.bf.money_spent+=price;
                    //couple_ob1.gf.val_received+=val;
                }
                while(couple_ob1.gf.m_cost>couple_ob1.bf.money_spent){
                    x=0;
                    System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[x].price+" Gift Type = Luxury");
                    log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[x].price+" Gift Type = Luxury"+System.lineSeparator());
                     
                    couple_ob1.bf.money_spent+=luxgift_ob[x].price;
                    x++;
                }
            }
            else if(couple_ob1.bf.type==1){//geek prefers to give utility gift when price is same plus one luxury gift
                int x=0,y=0;
                couple_ob1.bf.money_spent+=luxgift_ob[0].price;
                while(couple_ob1.gf.m_cost>couple_ob1.bf.money_spent){
                    if(essgift_ob[x].price<utilgift_ob[y].price){
                        System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+essgift_ob[x].price+" Gift Type = Essential");
                        log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+essgift_ob[x].price+" Gift Type = Essential"+System.lineSeparator());
                        price=essgift_ob[x].price;
                        x++;
                    }
                    else{
                         System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+utilgift_ob[y].price+" Gift Type = Utility");
                        log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+utilgift_ob[y].price+" Gift Type = Utility"+System.lineSeparator());
                        price=utilgift_ob[y].price;
                        y++;
                    }
                    couple_ob1.bf.money_spent+=price;
                    
            }
                System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[0].price+" Gift Type = Luxury");
                log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[0].price+" Gift Type = Luxury"+System.lineSeparator());
                while(couple_ob1.gf.m_cost>couple_ob1.bf.money_spent){
                    x=1;
                     System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[x].price+" Gift Type = Luxury");
                    log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[x].price+" Gift Type = Luxury"+System.lineSeparator());
                    couple_ob1.bf.money_spent+=luxgift_ob[x].price;
                    x++;
                }
        }
            else if(couple_ob1.bf.type==2){//generous give max cost gifts within their budget
                int x=0,y=0;
                while(couple_ob1.bf.money_spent<couple_ob1.bf.budget){
                    System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[x].price+" Gift Type = Luxury");
                    log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+luxgift_ob[x].price+" Gift Type = Luxury"+System.lineSeparator());
                    couple_ob1.bf.money_spent+=luxgift_ob[x].price;
                    x++;
                }
                x=0;
                 while(couple_ob1.bf.money_spent<couple_ob1.bf.budget){
                    if(essgift_ob[x].price>utilgift_ob[y].price){
                        System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+essgift_ob[x].price+" Gift Type = Essential");
                        log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+essgift_ob[x].price+" Gift Type = Essential"+System.lineSeparator());
                        price=essgift_ob[x].price;
                        x++;
                    }
                    else{
                        System.out.println(couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+utilgift_ob[y].price+" Gift Type = Utility");
                        log.write(date.toString()+" "+couple_ob1.bf.name+" sent gift to "+couple_ob1.gf.name+": Gift price = "+utilgift_ob[y].price+" Gift Type = Utility"+System.lineSeparator());
                         price=utilgift_ob[y].price;
                         y++;
                    }
                    couple_ob1.bf.money_spent+=price;
                }
                    
                }
            }
        }
        /**
         * Method to get the happiness and compatibility of each couple.
         * @param k variable defined in problem statement
         */
        public void getCoupleStats(int k){
            Stats s=new Stats();
            s.calcHappiness(couple_ob);
            s.printKHappiest(couple_ob,k );
            System.out.println();
            s.printKCompatible(couple_ob, k);
        }
    }
