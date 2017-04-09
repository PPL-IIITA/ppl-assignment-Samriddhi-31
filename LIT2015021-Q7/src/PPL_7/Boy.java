package PPL_7;



import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Abstract Class that simulates and defines the attributes of Generalized Virtual World Boy.
 * 
 */
public abstract class Boy {
     String name;
    int attr;
    int i_level;
    int budget;
    int min_attr;
    int money_spent;
    double happiness;
    String gf;
    /**
     * Constructor to initialize the attributes of Boy object with given values
     * @param a name of Boy
     * @param b attractiveness of Boy
     * @param c intelligence level of Boy
     * @param d budget of Boy
     * @param e minimum attraction requirements
     */
    public Boy(String a,int b,int c, int d,int e){
        name=a;
        attr=b;
        i_level=c;
        budget=d;
        min_attr=e;
       
    }

    /**
     *Abstract Method implemented by derived classes which simulates the activity of selecting gifts to be included in the Gift Basket
     * @param ob Girl object (Girlfriend of the Boy)
     * @param gift_ob   List of Gifts
     * @param log BufferedWriter object
     * @throws java.io.IOException
     */
    public abstract void selectGifts(Girl ob,Gift gift_ob[],BufferedWriter log)throws IOException;
    /**
     * Abstract Method implemented by derived classes which calculates happiness of Boy 
     * @param gf Girl object (Girlfriend of Boy)
     */
    public abstract void calcHappiness(Girl gf);
  
}
