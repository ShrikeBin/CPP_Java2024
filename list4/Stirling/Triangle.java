import java.util.ArrayList;

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
            else if(!(type.equals("s1")||type.equals("s2")))
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
                }
            }
            else if(type.equals("s2"))
            {
                for(int i = 0; i <= n; i++)
                {
                    triangle.add(new Row(i, "s2").getRow());
                }
            }
        }   
    }

    public ArrayList<ArrayList<Long>> GetTriangle()
    {
        return triangle;
    }
}
