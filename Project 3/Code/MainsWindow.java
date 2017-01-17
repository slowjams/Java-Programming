import model.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class MainsWindow extends JFrame
{
    Group group;
    public MainsWindow(Groups groups, int y)
    {
        group=groups.groups().get(0);
        setup(y);
        build();
        pack();
        setVisible(true);  
    }

    private void setup(int y)
    {
        setLocation(800, y);
        setTitle("Mains");
    }

    private void build()
    {   
        add(new MainsPanel());  
    }

    private class MainsPanel extends JPanel implements View
    {
        private TableModel model;
        private JTable table;
        
        public MainsPanel()
        {   
            group.attach(this);
            setup();
            build();    
        }

        private void setup()
        {   
            model = new TableModel();
            table = new JTable(model);
            //setPreferredSize(new Dimension(180, 60));
            setBorder(BorderFactory.createLineBorder(Color.green));
            setLayout(new FlowLayout());  
            //setLayout(new BorderLayout());// panel fits the frame?    
        }

        private void build()
        {   
            Box box = Box.createVerticalBox();
            box.add(table.getTableHeader());
            Box box2 = Box.createVerticalBox();
            box2.add(table);
            box2.setBorder(BorderFactory.createLineBorder(Color.green));
            box.add(box2);
            add(box);  
        }

        public void update()
        {
            model.fireTableDataChanged();
        }
    }

    private class TableModel extends AbstractTableModel
    {   private int rows = group.size();
        private final int cols = 2;
        private final String[] columnNames = {"Snack", "Left"};

        public int getRowCount()
        {   return rows;    }

        public int getColumnCount()
        {   return cols;    }

        public String getColumnName(int col)
        {   
            return columnNames[col];    
        }

        public Object getValueAt(int row, int col)
        {   
            //Group g = groups.groups().get(row);
            Snack s=group.snack(row);
            switch (col)
            {   case 0: return s.name();
                case 1: return s.serves();
                //case 2: return group.left();
                default: return "";    
            }
        }

        /*private String formatted(double amount)
        {   
        DecimalFormat form = new DecimalFormat("###,##0.00");
        return form.format(amount); 
        }*/

        public boolean isCellEditable(int row, int col)
        {   
            return false;    
        }

        
    }
}
