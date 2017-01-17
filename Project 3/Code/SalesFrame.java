import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
public class SalesFrame extends JFrame
{
    Groups groups;
    public SalesFrame(Groups groups)
    {
        this.groups=groups;
        setup();
        build();
        pack();
        setVisible(true);  
    }

    private void setup()
    {
        setLocation(600, 650);// change location later
        setTitle("");// or//?
    }

    private void build()
    {   
        add(new SalesPanel(groups));  
    }

}
