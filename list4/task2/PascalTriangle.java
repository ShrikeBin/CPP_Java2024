import java.util.ArrayList;
import java.util.List;

public class PascalTriangle 
{
    private List<List<Integer>> triangle;

    public PascalTriangle(int size) throws IllegalArgumentException
    {
        if(size < 1)
        {
            throw new IllegalArgumentException("Pascal cannot generate with size <1");
        }

        triangle = new ArrayList<>();

        for (int i = 0; i < size; i++) 
        {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) 
            {
                row.add(generateElement(i, j));
            }
            triangle.add(row);
        }
    }

    private int generateElement(int row, int col) 
    {
        if (col == 0 || col == row) 
        {
            return 1;
        } 
        else 
        {
            return generateElement(row - 1, col - 1) + generateElement(row - 1, col);
        }
    }

    public List<List<Integer>> getTriangle() 
    {
        return triangle;
    }
}
