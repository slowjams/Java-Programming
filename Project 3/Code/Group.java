package model;

import java.util.*;

public class Group extends Viewable
{   private String name;
    private LinkedList<Snack> snacks = new LinkedList<Snack>();

    public Group(String name)
    {   
        this.name = name;  
    }
    
    public void add(Snack snack)
    {   
        snacks.add(snack);    
    }
        
    public Snack snack(int i)
    {  
        return snacks.get(i);   
    }
    
    public int size()
    {   
        return snacks.size();  
    }
    
    public String name()
    {   
        return name;   
    }
    
    public LinkedList<Snack> snacks()
    {   
        return snacks;  
    }
}
