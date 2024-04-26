import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

import java.util.logging.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
                // zeby sie usunął Reader to jest w try( ... ) -> wtedy try go wyczyści
                try(BufferedReader reader = execute(i, j))
                {
                    BigInteger element = new BigInteger(reader.readLine());
                    row.add(element);
                }
                catch(IOException e)
                {
                        MyLogger.logger.log(Level.SEVERE, "C++ reading exception: ", e);
                        row.add(BigInteger.ZERO);
                }
            }

            triangle.add(row);
        }

    }

    private BufferedReader execute(int row, int element) throws IOException 
    {
        String[] command = {"./BIN/app.exe", Integer.toString(row), Integer.toString(element)};
        
        return new BufferedReader(new InputStreamReader((new ProcessBuilder(command).start()).getInputStream()));
    }

    public List<List<BigInteger>> getTriangle() 
    {
        return triangle;
    }
}
