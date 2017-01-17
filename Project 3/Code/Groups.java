package model;
import java.util.*;

public class Groups 
{   
    private LinkedList<Group> groups = new LinkedList<Group>();
    
    public Groups()          
    {   Group group = new Group("Mains");
        group.add(new Snack("burger",3.45));
        group.add(new Snack("wrap",4.32));
        groups.add(group);
        group = new Group("Sides");
        group.add(new Snack("fries",4.20));
        group.add(new Snack("muffin",2.50));
        group.add(new Snack("hashBrown",4.32));
        groups.add(group);
        group = new Group("Drinks");
        group.add(new Snack("coke",1.23));
        group.add(new Snack("koffee",2.34));
        group.add(new Snack("slurpee",3.45));
        group.add(new Snack("tea",4.56));
        group.add(new Snack("juice",5.67));
        groups.add(group);  }
            
    public LinkedList<Group> groups()
    {   return groups;    }
}
