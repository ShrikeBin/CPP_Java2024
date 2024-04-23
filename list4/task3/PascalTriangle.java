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

        try
        {
            for (int i = 0; i < size; i++) 
            {
                List<BigInteger> row = new ArrayList<>();
                
                for (int j = 0; j <= i; j++) 
                {
                    Process process = execute(i, j);

                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String output = reader.readLine();
                    BigInteger element = new BigInteger(output);
                    row.add(element);
                }

                triangle.add(row);
            }
        }
        catch (IOException e)
        {
            MyLogger.logger.log(Level.SEVERE, "C++ reading exception: ", e);
        }
    }

    private Process execute(int row, int element) throws IOException 
    {
        String[] command = {"./BIN/app.exe", Integer.toString(row), Integer.toString(element)};

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        return processBuilder.start();
    }

    public List<List<BigInteger>> getTriangle() 
    {
        return triangle;
    }
}
