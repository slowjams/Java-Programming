import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class RadioPanel extends JPanel
{   
    private ButtonGroup buttonGroup = new ButtonGroup();
    private Groups groups;
    int num=3;
    int y=200; //500
    public RadioPanel(Groups groups)
    {   
        this.groups=groups;
        setup(groups.groups().size());
        build(groups); 
    }

    private void setup(int groups)
    {   
        setPreferredSize(new Dimension(180, 80));//size?
        setBorder(BorderFactory.createLineBorder(Color.blue));
        setLayout(new FlowLayout());   
    }

    private void build(Groups Groups)
    {   
        JButton b= new JButton("Sales");
        b.addActionListener(new Listener());
        Box box = Box.createHorizontalBox();
        box.add(buttonBox());
        box.add(Box.createHorizontalStrut(30));
        box.add(b);
        add(box);

        /*add(new IncomePanel(groups));
        for (Group group: groups.groups())
        add(new SalePanel(group));  */
    }

    private Box buttonBox()
    {   
        Listener listener = new Listener();
        Box box = Box.createVerticalBox();
        box.add(button("Mains", listener));
        box.add(button("Sides", listener));
        box.add(button("Drinks", listener));
        return box; 
    }

    private JRadioButton button(String label, Listener listener)
    {   JRadioButton button = new JRadioButton(label);
        button.addActionListener(listener);
        buttonGroup.add(button);
        return button;  }

    private class Listener implements ActionListener
    {   public void actionPerformed(ActionEvent e)
        {   
            String click = e.getActionCommand();
            if(click.equals("Mains"))
            {
                new MainsWindow(groups,y);
            }
            else if(click.equals("Sides"))
            {
                new SidesWindow(groups,y);
            }
            else if(click.equals("Drinks"))
            {
                new DrinksWindow(groups,y);
            }
            else if(click.equals("Sales"))
            {
                new SalesFrame(groups);
                return;
            }
            num--;
            y=y+150;
            if(num==0)
            {
                num=3;
            }
        }
    }
}
