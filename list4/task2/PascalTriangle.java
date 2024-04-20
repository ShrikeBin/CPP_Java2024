import java.util.ArrayList;
import java.util.List;

public class PascalTriangle 
{
    private List<List<Long>> triangle;

    public PascalTriangle(int size) throws IllegalArgumentException
    {
        if(size < 1)
        {
            throw new IllegalArgumentException("Pascal cannot generate with size <1");
        }

        triangle = new ArrayList<>();

        for (int i = 0; i < size; i++) 
        {
            List<Long> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) 
            {
                row.add(generateElement(i, j));
            }
            
            triangle.add(row);
        }
    }

    private long generateElement(int n, int k) 
    {
        long result = 1;
        for(int i = 1; i <= k; ++i)
        {
            result *= n - k + i;
            result /= i;
        }
        return result;
    }

    public List<List<Long>> getTriangle() 
    {
        return triangle;
    }
}
