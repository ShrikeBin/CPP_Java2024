import java.util.Arrays;

public final class Decide 
{
    private Decide() throws InstantiationError
    {
        throw new InstantiationError("This is an abstract class you moron");
    } 

    static String which_figure(final String[] args) throws IllegalArgumentException
    {

        if(!(args[0] == "C" || args[0] == "H" || args[0] == "P" || args[0] == "Q" ))
        {
            throw new IllegalArgumentException("Unable to recognize figure code: " + args[0]);
        }

        if(args[0]=="Q")
        {
            if(!(args.length==5))
            {
                throw new IllegalArgumentException("Any Quadrilateral inputs four sides and an angle on last position");
            }

            double checker[] = new double[4];

            for(int i = 0; i < 4; i++)
            {   
                try
                {
                    checker[i] = Double.parseDouble(args[i]);
                }
                catch (final NumberFormatException e)
                {
                    System.out.println(args[0]+ " :: " + e.getStackTrace()[e.getStackTrace().length-1] + " :: " + e.getMessage());
                }
            }

            if(checker[0]==checker[1] && checker[1]==checker[2] && checker[2]==checker[3])
            {
                
            }

            
        }
        else if (args[0]=="C") 
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Cirlce inputs only radious");
            }
            return "C";
        }
        else if (args[0]=="P")
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Pentagon inputs only side size");
            }
            return "P";
        }
        else if (args[0]=="H")
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Hexagon inputs only side size");
            }
            return "H";
        }
    }
}
