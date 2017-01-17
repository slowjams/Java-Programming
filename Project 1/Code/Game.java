public class Game
{
    private Player player;
    private Dot[] dots;
    private Exit[] exit;
    private Enemy[] enemy;
    private Screen screen;
    private Vector a;
    public Game()
    {
        dots = new Dot[count('.')];
        enemy = new Enemy[count('e')];
        exit = new Exit[count('x')];
        int di = 0;
        int ei = 0;
        int xi = 0;
        for (int row = 0; row < Layout.ROWS.length; row++)
        {
            for (int col = 0; col < Layout.ROWS[row].length(); col++)
            {
                Vector pos = new Vector(col, row);
                char a = Layout.ROWS[row].charAt(col);
                if (a == '.')
                {
                    dots[di] = new Dot(pos);
                    di++; 
                }
                else if (a == 'e')
                {
                    enemy[ei] = new Enemy(pos);
                    ei++;
                }
                else if (a == 'p')
                {
                    player = new Player(pos);
                }
                else if (a == 'x')
                {
                    exit[xi] = new Exit(pos);
                    xi++;
                }
            }
        }
        screen = new Screen(Layout.ROWS[0].length(), Layout.ROWS.length);
    }

    public static int count(char t)
    {
        int count = 0;
        for (int row = 0; row < Layout.ROWS.length; row++)
        {
            for (int col = 0; col < Layout.ROWS[row].length(); col++)
            {
                if (Layout.ROWS[row].charAt(col) == t)
                {
                    count++; 
                }
            }
        }
        return count;
    }

    public void start()
    {
        do
        {
            display();
            input();
        }
        while (!over());
        display();
        player.finish();
    }

    public void display()
    {
        screen.clear();
        for (int row = 0; row < Layout.ROWS.length; row++)
        {
            for (int col = 0; col < Layout.ROWS[row].length(); col++)
            {
                if (Layout.ROWS[row].charAt(col) == '#')
                {
                    screen.setPixel(col, row, '\u25AF');
                }
            }
        }

        for (int row = 0; row < exit.length; row++)
        {
            if (exit[row].isOpen())
            {
                checkExit(row, 'o');
            }
            else
            {
                checkExit(row, 'x');
            } 
        }

        for (int row = 0; row < dots.length; row++)
        {
            if (dots[row].exists())
            {
                checkDot(row, '.'); 
            }
            else
            {
                checkDot(row, ' ');
            }
        }

        for (int row = 0; row < enemy.length; row++)
        {
            screen.setPixel(enemy[row].getPosition().getX(), enemy[row].getPosition().getY(), 'e');
        }
        screen.setPixel(player.getPosition().getX(), player.getPosition().getY(), 'p');
        screen.print();
    }
    
    public void checkExit(int a, char b)
    {
         screen.setPixel(exit[a].getPosition().getX(), exit[a].getPosition().getY(), b);
    }
    
    public void checkDot(int a, char b)
    {
         screen.setPixel(dots[a].getPosition().getX(), dots[a].getPosition().getY(), b);
    }
    
    public boolean over()
    {
        boolean over = false;
        for (int i=0; i<exit.length; i++)
        {
            over = over || exit[i].isReached();
        }
        return over || !player.isAlive();
    }

    public void input()
    {
        move(readMove());
    }

    private Vector readMove()
    {
        switch (Util.readChar("Move (l/r/u/d): "))
        {
            case 'l': a = Vector.LEFT; return Vector.LEFT;
            case 'r': a = Vector.RIGHT; return Vector.RIGHT;
            case 'u': a = Vector.UP; return Vector.UP;
            case 'd': a = Vector.DOWN; return Vector.DOWN;
            default: return null;
        }
    }

    public void move(Vector direction)
    {
        player.move(direction);
        for (int i = 0; i<count('.'); i++)
        {
            player.collect(dots[i]);
        }
        if (player.getCollectedDots() == count('.'))
        {
            for (int i = 0; i<count('x'); i++)
            {
                exit[i].open();
            }  
        }
        for (int i = 0; i<count('x'); i++)
        {
            player.reach(exit[i]);
        }

        for (int i = 0; i<count('e'); i++)
        {
            enemy[i].move(player);
        }
    }

    public String toString()
    {
        String s = " ";
        String es = "";
        String ex = " ";
        for (int i=0; i<dots.length; i++)
        {
            s += dots[i];
            s += " ";
        }
        for (int i=0; i<enemy.length; i++)
        {
            es += " ";
            es += enemy[i];
        }
        for (int i=0; i<exit.length; i++)
        {
            ex += exit[i];
            ex += " ";
        }
        return player + s + ex + es;
    }
}
