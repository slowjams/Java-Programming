import model.*;
import java.awt.*;
import javax.swing.*;

//MVC just update one better, colour, runtime error?
public class Root extends JFrame
{   public static void main(String[] args)
    {   
        //int list[10];
        new Root(new Groups());    }

    public Root(Groups groups)
    { 
        setup(); 
        build(groups);
        pack();
        setVisible(true);   
    }

    private void setup()
    {   
        setLocation(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setTitle("McDongs");
    }
    
    private void build(Groups groups)
    {   
        add(new RadioPanel(groups)); 
    }
}
