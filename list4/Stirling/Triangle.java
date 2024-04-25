import java.util.ArrayList;
import java.util.logging.Level;

public class Triangle
{
    protected final ArrayList<ArrayList<Long>> triangle = new ArrayList<ArrayList<Long>>(0);

    public Triangle(final int n, final String type) throws IllegalArgumentException
    {
        {
            if(n < 0)
            {
                throw new IllegalArgumentException("n should be >= 0, got " + n);
            }
            else if(!(type.equals("s1")||type.equals("s2")||type.equals("Bin")))
            {
                throw new IllegalArgumentException("Invalid type: " + type);
            }
        }

        {
            if(type.equals("s1"))
            {
                for(int i = 0; i <= n; i++)
                {
                    triangle.add(new Row(i, "s1").getRow());
                    AppLogger.logger.log(Level.FINEST, "added row");
                }
            }
            else if(type.equals("s2"))
            {
                for(int i = 0; i <= n; i++)
                {
                    triangle.add(new Row(i, "s2").getRow());
                    AppLogger.logger.log(Level.FINEST, "added row");
                }
            }
            else if(type.equals("Bin"))
            {
                for(int i = 0; i <= n; i++)
                {
                    triangle.add(new Row(i, "Bin").getRow());
                    AppLogger.logger.log(Level.FINEST, "added row");
                }
            }
        }   
    }

    public ArrayList<ArrayList<Long>> GetTriangle()
    {
        return triangle;
    }
}
