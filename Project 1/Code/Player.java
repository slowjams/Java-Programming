public class Player
{
    private Vector position;
    private int collectedDots;
    private boolean alive;
    private Vector ud;
    private Vector temp;
    public Player(Vector position)
    {
        this.position = position;
        this.collectedDots = 0;
        this.alive = true;
    }

    public int getCollectedDots()
    {
        return collectedDots;
    }

    public void move(Vector direction)
    {
        position.add(direction);
        if ( Layout.ROWS[position.getY()].charAt(position.getX()) == '#')
        {
            position.add(direction.opposite());
        }
    }

    public void collect(Dot dot)
    {
        collectedDots += dot.disappear(position);
    }

    public void die(Vector enemyPosition)
    {
        if (position.equals(enemyPosition))
        {
            alive = false;
        }
    }

    public void reach(Exit exit)
    {
        exit.reach(position);
    }

    public Vector getPosition()
    {
        return position;
    }

    public void finish()
    {
        System.out.println(alive ? "You win!" : "You lose!");
    }

    public boolean isAlive()
    {
        return alive;
    }

    public String toString()
    {
        return "Player[" + stars() + "]" + Util.coordsStr(position, alive);
    }

    private String stars()
    {
        String s = "";
        for (int i = 0; i < collectedDots; i++)
            s += "*";
        return s;
    }
}
