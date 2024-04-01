public final class Utils 
{
    private Utils() throws InstantiationError
    {
        throw new InstantiationError("This is an abstract class you moron");
    } 

    static double[] translate_snippet(final String[] args, final int begin, final int end) throws NumberFormatException, IllegalArgumentException
    {
        if(begin < 0 || end > args.length-1)
        {
            throw new IllegalArgumentException("begin: " + begin + " end: " + end + " are over the range of the array of size: " + args.length);
        }

        double result[] = new double[end-begin+1];

        for(int i = 0; i < result.length; i++)
        {   
           result[i] = Double.parseDouble(args[begin+i]);
        } 

        return result;
    }

    static String which_figure(final String[] args) throws IllegalArgumentException
    {

        if(!(args[0].equals("C") || args[0].equals("H") || args[0].equals("P") || args[0].equals("Q")))
        {
            throw new IllegalArgumentException("Unable to recognize figure code: " + args[0]);
        }

        if(args[0].equals("Q"))
        {
            if(!(args.length==6))
            {
                throw new IllegalArgumentException("Any Quadrilateral inputs four sides and an angle on last position");
            }


            double checker[] = new double[5];
            checker = translate_snippet(args,1,5);


            if(checker[0]==checker[1] && checker[1]==checker[2] && checker[2]==checker[3] && args[5].equals("90"))
            {
                return "Square";
            }
            else if (args[5].equals("90"))
            {
                return "Rectangle";
            }
            else
            {
                return "Rhombus";
            }

            
        }
        else if (args[0].equals("C")) 
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Cirlce inputs only radious");
            }
            return "Circle";
        }
        else if (args[0].equals("P"))
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Pentagon inputs only side size");
            }
            return "Pentagon";
        }
        else if (args[0].equals("H"))
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Hexagon inputs only side size");
            }
            return "Hexagon";
        }
        else
        {
            return "Invalid";
        }
    }
}
