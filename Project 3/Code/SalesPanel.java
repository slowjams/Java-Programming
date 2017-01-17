import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.text.*;

public class SalesPanel extends JPanel
{
    private TableModel model;
    private JTable table;
    private JTextField field = new JTextField(10);
    private Groups groups;
    private double price=0;
    public SalesPanel(Groups groups)
    {
        this.groups=groups;
        setup();
        build(); 
    }

    private void setup()
    {   
        model = new TableModel();
        table = new JTable(model);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(40);
        //setPreferredSize(new Dimension(180, 235));
        //setBorder(BorderFactory.createLineBorder(Color.blue));  
        //setLayout(new BorderLayout());//why use this the jtextfield size different?
        setLayout(new FlowLayout()); 
    }

    private void build()
    {   
        JButton b= new JButton("Pay");
        b.addActionListener(new Listener());
        Box box = Box.createVerticalBox();
        box.add(table.getTableHeader());
        Box box2=Box.createHorizontalBox();
        box2.add(table);
        box2.setBorder(BorderFactory.createLineBorder(Color.blue));
        box.add(box2);
        box.add(Box.createVerticalStrut(20));
        Box box3=Box.createHorizontalBox();
        box3.add(b);
        box3.add(Box.createHorizontalStrut(5));
        box3.add(field);
        box.add(box3);
        add(box);
    }

    private String formatted(double amount)
    {  
        DecimalFormat twoD = new DecimalFormat("###,##0.00");
        return twoD.format(amount);  
    }

    private class TableModel extends AbstractTableModel
    {   private int rows;
        private final int cols = 2;
        private final String[] columnNames = {"Snack", "Buy"};

        public int getRowCount()
        {   
            rows=0;
            for(Group group:groups.groups())
            {
                rows+=group.size();
            }
            return rows;    
        }

        public int getColumnCount()
        {   
            return cols;    
        }

        public String getColumnName(int col)
        {   
            return columnNames[col];    
        }

        public Object getValueAt(int row, int col)
        {   
            Snack s;
            if(row<=1)
            {
                s=groups.groups().get(0).snack(row);
            }
            else if(row>=2 && row<=4)
            {
                s=groups.groups().get(1).snack(row-2);
            }
            else 
            {
                s=groups.groups().get(2).snack(row-5);
            }

            switch (col)
            {   
                case 0: return s.name();
                case 1: return"";
                default: return "";    
            }
        }

        public boolean isCellEditable(int row, int col)
        {   
            return col==1;   
        }
        
        /*public Class getColumnClass(int col) 
        {
            if(col==1)
            {
               return Integer.class; 
            }
            else
            {
                return String.class;
            }
        }*/
        
        public void setValueAt(Object o, int row, int col) 
        {
            String value = (String) o;
            int number = Integer.parseInt(value);
            Snack s;
            if(row<=1)
            {
                s=groups.groups().get(0).snack(row);
            }
            else if(row>=2 && row<=4)
            {
                s=groups.groups().get(1).snack(row-2);
            }
            else
            {
                s=groups.groups().get(2).snack(row-5);
            }
            price+=s.sell(number);
            field.setText("$"+formatted(price));
            for (Group group: groups.groups())
            {
                if(group.snacks().contains(s))
                {
                    group.update();
                }
            }
        }
    }

    private class Listener implements ActionListener
    {   public void actionPerformed(ActionEvent e)
        {   
            price=0;
            field.setText("");
        }
    }
}
