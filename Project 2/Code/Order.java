import java.text.*;
import java.util.*;
import java.io.*;
public class Order implements Serializable
{
    private LinkedList<Snack> snack2=new LinkedList<Snack>();
    private String z=null;
    private boolean gate;
    private LinkedList<Snack>separateOrder = new LinkedList<Snack>();
    private String order=null;
    
    public Order()
    {
        order=readOrders();
        gate=true;
    }

    public Order(String s)
    {
        this.z=s;
        gate=false;
        order=readOrders();
    }

    public void add(Snack s)
    {    
        for(Snack t:snack2)
        {
            if(s==t)
            {
                if(gate)
                {
                    s.decrease(); 
                }
                else
                {
                    s.addReserve();
                }
                return;
            }
        }
        if(gate)
        {
            s.decrease();
        }
        else
        {
            s.addReserve();
        }
        snack2.add(s);
    }

    private String readOrders()
    {
        System.out.print("  Order: ");
        return In.nextLine();
    }
    
    public String getOrders()
    {
        return order;
    }
    
    public void setOrder(Snack c)
    {
        if(!separateOrder.contains(c))
        {
            separateOrder.add(c);
        }
    }
    
    public void clearList()
    {
        snack2.clear();
        separateOrder.clear();
    }

    public boolean getGate()
    {
        return !gate;
    }
    
    public void setGate()
    {
        gate=true;
    }

    public String toString()
    {
        String s = "The Order is";
        double cost=0;
        if(gate)
        {
            for (Snack i: snack2)
            {
                cost=cost+i.getCost();
                if(separateOrder.contains(i))
                {
                    s+=" ";
                }
                else
                {
                    s += "\n  " + i.toString2();//without last toString()?
                }
            }
            
            for(Snack k:separateOrder)
            {
                s += "\n  " + k.toString2();
            }
            s += "\n  "+"The cost is $"+formatted(cost);
        }
        else
        {
            for (Snack i: snack2)
            {
                s += "\n  " + i.toString3();//without last toString() and how to reuse??
            }
        }
        return s;  
    }

    public boolean hasString(String c)
    {
        return z.equals(c);
    }
    
    private String formatted(double amount)
    {   
        DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount);  
    }
}
