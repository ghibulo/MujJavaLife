
public class Bunka
{

    private boolean ziju, buduzit;
    private Bunka bj,bs,bv,bz;
    private Bunka bsv,bjv,bjz,bsz;
    private int xPos, yPos;

    
    public Bunka(int xp, int yp, boolean zivot)
    {
        xPos = xp; yPos = yp;ziju = zivot;

    }
    
    public void nastavSousedySVJZ (Bunka s, Bunka v,Bunka j,Bunka z, Bunka sv, Bunka jv, Bunka jz, Bunka sz) 
    {
        bs = s; bv = v; bj = j; bz = z; bsv = sv; bjv = jv; bjz = jz; bsz = sz;
    }
    

    public void prehodnotExistenci()
    {
        int zivychsousedu = bs.zijes() + bv.zijes() + bj.zijes()+ bz.zijes()+bsv.zijes() + bjv.zijes() + bjz.zijes() + bsz.zijes() ;
        if (ziju) {
            if (zivychsousedu<=1) {
                buduzit = false;
                return;
            }
            if (zivychsousedu<4) {
                buduzit = true;
                return;
            }
            buduzit = false;
            return;
        } else {
            if (zivychsousedu==3) {
                buduzit = true;
                return;
            }
        }
        return;
    }
    
    public boolean novaGenerace() 
    {
        return (ziju = buduzit);
        
        
    }
    
    public int zijes()
    {
        return ziju?1:0;
    }
    
    public void nastavZivot(boolean zivot)
    {
        buduzit = ziju = zivot;
    }
}
