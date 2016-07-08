public class Pozice
{


    /** Vodorovná souřadnice. */
    public final int x;

    /** Svislá souřadnice. */
    public final int y;


    public Pozice(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }




    @Override
    public boolean equals(Object o)
    {
        return (o instanceof Pozice)      &&
               (((Pozice)o).x == this.x)  &&
               (((Pozice)o).y == this.y);
    }


    @Override
    public String toString()
    {
        return "Pozice[x=" + x + ", y=" + y + "]";
    }

}
