package model;

public class Snack
{   private String name;
    private int serves = 3;
    private double price;
    
    public Snack(String name, double price)
    {   
        this.name = name;   
        this.price = price;  
    }
     
    public double sell(int n)
    {   
        double cost=price*n;
        serves = serves-n;    
        return cost;
    }
    
    public String name()
    {   return name;    }
    
    public int serves()
    {   return serves;  }
}
