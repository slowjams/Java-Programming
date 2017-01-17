import java.util.*;
import java.text.*;
import java.io.*;
public class Substitute implements Serializable
{
    private LinkedList<Snack> snacks3 = new LinkedList<Snack>();
    //private boolean b=true;
    public Substitute()
    {
       
    }

    public void addSnack(Snack s)
    {
        snacks3.add(s);
    }

    /*private void nextSnack(Snack s)
    {
        snacks3.add(s);
    }*/

    public boolean containElement(Snack s)
    {
        return snacks3.contains(s);
    }
    
    public Snack circuleElement(Snack s)
    {
        for (Snack snack:snacks3)
        {
            if(snack!=s && snack.checkServes())
            {
                String string2=snack.getName2();
                System.out.print(string2);
                return snack;
            }
        }
        return s;// just need for the structure,try to get rid of it?
    }
    
    public void removeElement(Snack s)//try inside the loop above?
    {
       snacks3.remove(s);
    }
    
    private char readSubstitute()
    {
       return In.nextChar();
    }
    
    public boolean checkLast(Snack s)
    {
       return s==snacks3.getLast();
    }
}
