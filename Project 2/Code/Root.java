//import java.util.*;
//import java.text.*;
//import java.util.*;
import java.io.*;
public class Root 
{   public static void main(String[] args)
    {   new Root();   }
    private Kitchen kitchen;
    public Root()
    {   
        try
        {
            readorstore();
        }
        catch(Exception e)
        {
            e.printStackTrace();//???
        }
    }

    private void readorstore()
    {
        ObjectInputStream abc=null;
        try
        {
            abc=new ObjectInputStream(new FileInputStream("Assignment One"));
            kitchen=(Kitchen)abc.readObject();
            readLoop();
        }
        catch(FileNotFoundException e)
        {
            kitchen=new Kitchen();
            readLoop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(abc != null)
                {
                    abc.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            } 
        }
    }

    private void readLoop()
    {
        char choice;
        do
        {
            choice=readChoices();
            switch(choice)
            {   
                case 'z': kitchen.setChoice('z'); break;//Order or=new Order(readName());add(or); reserveOrder.add(or); break;
                case 'o': kitchen.setChoice('o'); break;//add(new Order());  break;
                case 'u': kitchen.setChoice('u'); break;//checkString(readName()); break;
                case 's': kitchen.setChoice('s'); break;//show ();  break;
                case 'f': break;                  
                case 'x': System.exit(0); break;
                default: help(); break;
            }
        } while (!(choice=='x') && choice!='f');//try without while still work?
        if(choice=='f')
        {
            store();
        }
    }

    private char readChoices()
    {
        System.out.print("Choice: ");
        return In.nextChar();
    }

    private void store()
    {   
        ObjectOutputStream xyz=null;
        try {
            xyz=new ObjectOutputStream(new FileOutputStream("Assignment One"));//try different title?
            xyz.writeObject(kitchen);
            System.out.println("  Stored to file");
        }
        catch (Exception e)
        {
             e.printStackTrace();
        }
        finally
        {
            try
            {
                if(xyz!=null)
                {
                    xyz.close();
                }
            }
            catch (Exception e)
        {
             e.printStackTrace();
        }
        }
    }

    private void help()
    {
        System.out.println("The choices are:");
        System.out.println("  o: make a new order");
        System.out.println("  z: set your favourite order");
        System.out.println("  u: use your favourite order");
        System.out.println("  s: show the stock");
        System.out.println("  f: store to file");
        System.out.println("  x: exit");
    }
}