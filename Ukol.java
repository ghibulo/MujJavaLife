import java.util.Random;

public class Ukol
{

    public int[] x;
    private int[] y;
    static int MAX=10;

    Random rg;
    
    /**
     * Constructor for objects of class Ukol
     */
    public Ukol()
    {
        rg = new Random();
    }


    public void vypln()
    {
       x = new int[MAX];
       for (int i=0;i<MAX;i++) {
           x[i] = 2;
        }
           
        x[MAX/2] = 5;
    }
    
    public void proved() {
        for (int i=0;i<MAX;i++) {
            if ((x[i]%2)==1) {
                dejNuluNaPozici(i);
                return;
            }
        }
        dejNuluNaPozici(MAX);
        tiskniPole();
    }    
    
    public void tiskniPole() {
        
        for (int i=0;i<x.length;i++) {
            System.out.println(i+": "+x[i]);
        }
    
    }
    
    public void dejNuluNaPozici(int i) {
        
        y= new int[MAX+1];
        
        for(int j=0;j<i;j++) {
            y[j]=x[j];
        }
        
        y[i]=0;
        
        for(int j=i+1;j<(MAX+1);j++) {
            y[j]=x[j-1];
        }
        
        x=y;
    }
    
}
