import java.util.ArrayList;

public class Row
{
    private ArrayList<Long> result = new ArrayList<Long>(0);

    public Row(final int n, final String type) throws IllegalArgumentException
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
                for(int m = 0; m <= n; m++)
                {
                    result.add(Math.StirlingFirst(n, m));
                }
            }
            else if(type.equals("s2"))
            {
                for(int m = 0; m <= n; m++)
                {
                    result.add(Math.StirlingSecond(n, m));
                }
            }
        }   

    }

    public ArrayList<Long> getRow()
    {
        return result;
    }
}