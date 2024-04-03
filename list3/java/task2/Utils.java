public final class Utils 
{
    private Utils() throws InstantiationError
    {
        throw new InstantiationError("This is an abstract class you moron");
    } 

    private static void validate(final String[] args) throws NumberFormatException, IllegalArgumentException
    {
        if(!(args.length == 2 || args.length == 3))
        {
            throw new IllegalArgumentException("Invalid amount of arguments: " + args.length);
        }

        double result[] = new double[args.length-1];

        for(int i = 0; i < result.length; i++)
        {   
           result[i] = Double.parseDouble(args[i+1]);
           if (result[i] < 0)
           {
            throw new IllegalArgumentException("None of the arguments can be negative");
           }
        }
    }

    public static Boolean isSimple(final String type)
    {
        if(type.equals("Square")||type.equals("Circle")||type.equals("Pentagon")||type.equals("Hexagon"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String input_recognition(final String[] args) throws IllegalArgumentException, NumberFormatException
    {
        validate(args);

        if(args[0].equals("Sq"))
        {
            if (!(args.length == 2))
            {
                throw new IllegalArgumentException("Square inputs only side size");
            }
            return "Square";
        }
        else if (args[0].equals("C")) 
        {
            if (!(args.length == 2))
            {
                throw new IllegalArgumentException("Cirlce inputs only radious");
            }
            return "Circle";
        }
        else if (args[0].equals("P"))
        {
            if (!(args.length == 2))
            {
                throw new IllegalArgumentException("Pentagon inputs only side size");
            }
            return "Pentagon";
        }
        else if (args[0].equals("H"))
        {
            if (!(args.length == 2))
            {
                throw new IllegalArgumentException("Hexagon inputs only side size");
            }
            return "Hexagon";
        }
        else if (args[0].equals("Re")) 
        {
            if (!(args.length == 3))
            {
                throw new IllegalArgumentException("Rectangle inputs side sizes");
            }
            return "Rectangle";
        }
        else if (args[0].equals("Rh")) 
        {
            if (!(args.length == 3))
            {
                throw new IllegalArgumentException("Rhombus inputs side size and angle");
            }
            if(!(Double.parseDouble(args[2]) < 180))
            {
                throw new IllegalArgumentException("That is not a correct angle for a Rhmobus: "+args[2]);
            }
            return "Rhombus";
        }
        else
        {
            throw new IllegalArgumentException("Unable to recognize figure code: " + args[0]);
        }
    }
}
