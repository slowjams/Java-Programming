import java.util.*;

public class Util
{
    public static final Scanner keyboard = new Scanner(System.in);

    public static String coordsStr(Vector p, boolean show)
    {
        return show ? p.toString() : "(-,-)";
    }

    public static String objectStr(String name, Vector p, boolean show)
    {
        return name + coordsStr(p, show);
    }

    public static char readChar(String prompt)
    {
        System.out.print(prompt);
        String line = keyboard.nextLine();
        if (line.isEmpty())
            return '\0';
        else
            return line.charAt(0);
    }

    public static int readInt(String prompt)
    {
        System.out.print(prompt);
        int i = keyboard.nextInt();
        keyboard.nextLine();
        return i;
    }
}
