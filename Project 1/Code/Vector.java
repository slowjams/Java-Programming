public class Vector
{
    public static final Vector LEFT = new Vector(-1, 0);
    public static final Vector RIGHT = new Vector(1, 0);
    public static final Vector UP = new Vector(0, -1);
    public static final Vector DOWN = new Vector(0, 1);

    private int x;
    private int y;

    public Vector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Vector opposite()
    {
        return new Vector(-x, -y);
    }

    public boolean equals(Vector other)
    {
        return this.x == other.x && this.y == other.y;
    }

    public void add(Vector other)
    {
        x += other.x;
        y += other.y;
    }

    public void sub(Vector other)
    {
        x -= other.x;
        y -= other.y;
    }

    public Vector clone()
    {
        return new Vector(x, y);
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
