import java.text.*;
import java.io.*;
public class Snack implements Serializable
{
    private String name;
    private int serves=3;
    private double price;
    private int reserve=0;
    private int orderFilter=0;
    private boolean filterSetter=false;
    private String s1="  We don't have enough ";
    private String s2="  Would you like some ";

    public Snack(String name, double price)
    {
        this.name=name;
        this.price=price;
    }

    public String getName()
    {
        return s1+name;
    }

    public String getName2()
    {
        return s2+name+"? ";
    }
    
    public boolean compareServes(int num)
    {
        return serves-num>=0;
    }

    public void decrease()
    {
        serves--;
    }

    public String toString()
    {
        return name+": "+serves+" left";
    }

    public int getServes()
    {
        return serves;
    }

    public String toString2()
    {
        if (filterSetter)
        {
            String n=name+": "+(3-serves-orderFilter);
            orderFilter=3-serves;
            return n;
        }
        else
        {
            filterSetter=true;
            orderFilter=3-serves;
            return name+": "+orderFilter;
        }
    }

    public void addReserve()
    {
        reserve++;
    }

    public String toString3()
    {
        return  name+": "+reserve;
    }
    //yes it can try reduce toString function number later
    public double getCost()
    {
        if (filterSetter)
        {
            return price*(3-serves-orderFilter);
        }
        else
        {
            return price*(3-serves);
        }
    }
    
    public boolean checkServes()
    {
        return !(serves==0);
    }
}
