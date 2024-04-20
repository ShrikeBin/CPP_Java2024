import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;


public class PascalTriangle 
{
    private List<List<BigInteger>> triangle;

    public PascalTriangle(int size) throws IllegalArgumentException
    {
        if(size < 1 )
        {
            throw new IllegalArgumentException("Pascal cannot generate with size < 1");
        }

        triangle = new ArrayList<>();

        for (int i = 0; i < size; i++) 
        {
            List<BigInteger> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) 
            {
                row.add(generateElement(i, j));
            }

            triangle.add(row);
        }
    }

    private BigInteger generateElement(int n, int k) 
    {
        BigInteger result = BigInteger.valueOf(1);

        for (int i = 1; i <= k; ++i) 
        {
            result = result.multiply(BigInteger.valueOf(n - k + i));
            result = result.divide(BigInteger.valueOf(i));
        }
        return result;
    }

    public List<List<BigInteger>> getTriangle() 
    {
        return triangle;
    }
}
