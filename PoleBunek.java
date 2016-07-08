import java.lang.Thread.*;
import java.awt.*;
public class PoleBunek
{

    private Bunka[][] pole;
    private int krok, strana;


    public PoleBunek()
    {
        pole  = new Bunka[20][20];
        for(int i=0; i<20; i++)
                        for(int j=0; j<20; j++) {
                                pole[i][j] = new Bunka(i,j,false);
                               
                        }
        for(int i=0; i<20; i++)
          for(int j=0; j<20; j++) {
             pole[i][j].nastavSousedySVJZ(getBunku(getSeverni(i,j)), getBunku(getVychodni(i,j)),
                                          getBunku(getJizni(i,j)), getBunku(getZapadni(i,j)),
                                          getBunku(getSV(i,j)),getBunku(getJV(i,j)),getBunku(getJZ(i,j)),getBunku(getSZ(i,j)));
             if ((int)(Math.random() * 2) == 0) umrtviBunku(i,j); else ozivBunku(i,j);
             //umrtviBunku(i,j);
             
          }
          ozivBunku(1,2);ozivBunku(1,3);ozivBunku(2,4);ozivBunku(3,1);ozivBunku(4,2);ozivBunku(4,3);
                        
    }
    
    public void novaGenerace(Graphics g, boolean odtimeru)
    {
        if (odtimeru) {
            for(int i=0; i<20; i++)
                        for(int j=0; j<20; j++) {
                                pole[i][j].prehodnotExistenci();                           
                        }
        }
        for(int i=0; i<20; i++)
                        for(int j=0; j<20; j++) {
                                if(pole[i][j].novaGenerace())
                                    g.fillOval(i*krok, j*krok, krok, krok);
                                
                                    
                        
                                    
                                    
                        }
    }
    
    
    private Bunka getBunku(Pozice poz) 
    {
        return pole[poz.getX()][poz.getY()];
    }

    private Pozice getSeverni(int x, int y)
    {
        Pozice nova;
        if (y==0) {nova = new Pozice(x,19);} else nova = new Pozice(x,--y);
        return nova;
        
    }

    
    private Pozice getJizni(int x, int y)
    {
        Pozice nova;
        if (y==19) {nova = new Pozice(x,0);} else nova = new Pozice(x,++y);
        return nova;
        
    }
    
    
    private Pozice getZapadni(int x, int y)
    {
        Pozice nova;
        if (x==0) {nova = new Pozice(19,y);} else nova = new Pozice(--x,y);
        return nova;
        
    }
    
    private Pozice getVychodni(int x, int y)
    {
        Pozice nova;
        if (x==19) {nova = new Pozice(0,y);} else nova = new Pozice(++x,y);
        return nova;
        
    }    

        private Pozice getSV(int x, int y)
    {
        if (x==19) {x=0;} else ++x;
        if (y==0) {y=19;} else --y;
        return new Pozice(x,y);
        
    }    
    
    
        private Pozice getJV(int x, int y)
    {
        if (x==19) {x=0;} else ++x;
        if (y==19) {y=0;} else ++y;
        return new Pozice(x,y);
        
    }    
    
        private Pozice getJZ(int x, int y)
    {
        if (x==0) {x=19;} else --x;
        if (y==19) {y=0;} else ++y;
        return new Pozice(x,y);
        
    }    
    
    
        private Pozice getSZ(int x, int y)
    {
        if (x==0) {x=19;} else --x;
        if (y==0) {y=19;} else --y;
        return new Pozice(x,y);
        
    }    
    
    
    
    
    public void ozivBunku(int kdeX, int kdeY)
    {

        pole[kdeX][kdeY].nastavZivot(true);
    }
    
    
    public void umrtviBunku(int kdeX, int kdeY)
    {

        pole[kdeX][kdeY].nastavZivot(false);
    }
    
    private void nakresliPole(Graphics g) {
        int x, y, x2, y2;



                // Vykresleni 10 car, jejichz koncove body jsou 
                // vygenerovany nahodne.
                for(int i=0; i <= 20; i++) {
                        
                       g.drawLine(i*krok,0,i*krok,strana);
                       g.drawLine(0,i*krok,strana,i*krok);
                        // Nacteni nahodnych souradnic, definujicich
                        // koncove body kazde cary.
                        /*
                        x = rand.nextInt(width-ins.left);
                        y = rand.nextInt(height-ins.bottom);
                        x2 = rand.nextInt(width-ins.left);
                        y2 = rand.nextInt(height-ins.bottom);

                        // Vykresleni cary.
                        g.setColor(Color.green);
                        g.fillOval(x, y, x2%100, y2%100);*/
                    }
        
    }
    
    public void kresli(Graphics g, boolean odtimeru) {
        nakresliPole(g);
        g.setColor(Color.green);
        novaGenerace(g, odtimeru);
        
    }
    
    public void nastavVelikost(int akrok) {
        krok = akrok;
        strana = 20*akrok;
    }
    
    
    
}
