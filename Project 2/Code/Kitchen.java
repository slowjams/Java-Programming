import java.io.*;
import java.util.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class Kitchen implements Serializable
{
    private LinkedList<Snack> snacks = new LinkedList<Snack>();
    private LinkedList<Order> reserveOrder = new LinkedList<Order>();
    private LinkedList<Substitute> groupsnacks = new LinkedList<Substitute>();
    private Snack b,w,f,m,h,c,k,s,t,j;
    private Substitute main,sides,drinks;
    private String fileName = "AP Assignment One";

    public Kitchen()
    {   
        setup();
        //readLoop();
    }

    public void setup()//try private
    {
        main=new Substitute();
        sides=new Substitute();
        drinks=new Substitute();
        groupsnacks.add(main);
        groupsnacks.add(sides);
        groupsnacks.add(drinks);

        b=new Snack("burger",3.45);//try add directly
        snacks.add(b);
        w=new Snack("wrap",4.32);
        snacks.add(w);
        f=new Snack("fries",4.2);
        snacks.add(f);
        m=new Snack("muffin",2.5);
        snacks.add(m);
        h=new Snack("hashBrown",4.32);
        snacks.add(h);
        c=new Snack("coke",1.23);
        snacks.add(c);
        k=new Snack("koffee",2.34);
        snacks.add(k);
        s=new Snack("slurpee",3.45);
        snacks.add(s);
        t=new Snack("tea",4.56);
        snacks.add(t);
        j=new Snack("juice",5.67);
        snacks.add(j);

        main.addSnack(b);
        main.addSnack(w);
        sides.addSnack(f);
        sides.addSnack(m);
        sides.addSnack(h);
        drinks.addSnack(c);
        drinks.addSnack(k);
        drinks.addSnack(s);
        drinks.addSnack(t);
        drinks.addSnack(j);
    }

    public void setChoice(char c)
    {
        char choice=c;

        //choice=readChoices();
        switch(choice)
        {   
            case 'z': Order or=new Order(readName());add(or); reserveOrder.add(or); break;
            case 'o': add(new Order());  break;
            case 'u': checkString(readName()); break;
            case 's': show ();  break;
            //case 'f':  break;                  
            //case 'x': System.exit(0); break;
            //default: help(); break;
        }

    }

    /*private char readChoices()
    {
    System.out.print("Choice: ");
    return In.nextChar();
    }*/

    private String readName()
    {
        System.out.print("  Name: ");
        return In.nextLine();
    }

    private void checkString(String c)
    {
        for (Order ro:reserveOrder)
        {
            if(ro.hasString(c))
            {
                ro.setGate();
                add(ro);
                ro.clearList();
                return;
            }
        }
        System.out.println("  Sorry, there is no stored order for me!");
    }

    /*private void setSetter()
    {
    setter=false;
    }*/

    private void add(Order order)
    {    
        String o=order.getOrders();
        int num=1;
        for(int n=0;n<o.length();n++)
        {
            char z=o.charAt(n);
            if(Character.isDigit(z))
            {
                num=z-'0';
            }
            else 
            {
                switch(z)
                {   
                    case 'b': isSubstitute(order,num,b); break;
                    case 'w': isSubstitute(order,num,w); break;
                    case 'f': isSubstitute(order,num,f); break;
                    case 'm': isSubstitute(order,num,m); break;
                    case 'h': isSubstitute(order,num,h); break;
                    case 'c': isSubstitute(order,num,c); break;
                    case 'k': isSubstitute(order,num,k); break;
                    case 's': isSubstitute(order,num,s); break;
                    case 't': isSubstitute(order,num,t); break;
                    case 'j': isSubstitute(order,num,j); break;
                    default: System.out.println("  Sorry, we don't serve "+z);
                }  
                num=1;
            }
        }
        System.out.println(order);
    }

    private void isSubstitute(Order order,int num,Snack s)
    {
        if(s.compareServes(num) || order.getGate())
        {
            for(int i=0;i<num;i++)
            {
                order.add(s);
            }
            return;
        }
        char substitute='c';//just random letter to fullfil initizing requirement?
        Snack temp=null;
        Substitute bus=null;
        do
        {
            String string=s.getName();
            System.out.println(string);
            for(Substitute sub:groupsnacks)
            {
                if(sub.containElement(s))
                {
                    bus=sub;
                    temp=sub.circuleElement(s);
                    substitute=readSubstitute();
                }
            }
            int cn=s.getServes();
            for(int n=0;n<cn;n++)
            {
                order.add(s);
                num--;
            }  
            if(substitute=='s')
            {
                return;
            }
            else if(substitute=='n')
            {
                //bus.removeElement(s);
                Snack k=null;
                do
                {
                    if(bus.checkLast(temp))
                    {
                        return;
                    }
                    String string2=s.getName();
                    System.out.println(string2);
                    k=bus.circuleElement(temp);
                    bus.removeElement(temp);
                    substitute=readSubstitute();
                    temp=k;
                }
                while(substitute=='n');
            }
            if(temp.compareServes(num) && !(substitute=='n'))
            {
                for(int n=0;n<num;n++)
                {
                    order.add(temp);
                }
                order.setOrder(temp);
                return;
            }
            else if(!(substitute=='n'))
            {
                order.setOrder(temp);
                if(bus.checkLast(temp))
                {
                    for(int ti=0;ti<temp.getServes();ti++)
                    {
                        order.add(temp);
                        return;
                    }  
                }
                s=temp;
            }
        }
        while(!(substitute=='s'));
    }

    private char readSubstitute()
    {
        return In.nextChar();
    }

    /*private String readOrders()
    {
    System.out.print("  Order: ");
    return In.nextLine();
    }*/

    private void show()
    {   
        System.out.println(toString());
    }

    public String toString()//ig private can not overide toString in Java.lang,.object attempting to assign weak access privileges, was public?
    {   
        String s = "The kitchen has";
        for (Snack temp: snacks)
            s += "\n  " + temp.toString();
        return s;   
    }
}