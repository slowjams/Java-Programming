public class Enemy
{
    private Vector position;
    private Vector direction;

    public Enemy(Vector position)
    {
        this.position = position;
        this.direction = Vector.LEFT;
    }

    public Vector getPosition()
    {
        return position;
    }

    public void move(Player player)
    {
        kill(player);
        position.add(direction);
        if ( Layout.ROWS[position.getY()].charAt(position.getX()) == '#')
        {
            position.add(direction.opposite());
        }
        kill(player);
    }

    private void kill(Player player)
    {
        player.die(position);
    }

    public String toString()
    {
        return Util.objectStr("Enemy", position, true);
    }
}
