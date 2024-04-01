public final class Utils 
{
    private Utils() throws InstantiationError
    {
        throw new InstantiationError("This is an abstract class you moron");
    } 

    static double[] translate_args(final String[] args, final int begin, final int end) throws NumberFormatException
    {
        double result[] = new double[end];

        for(int i = begin - 1; i < end+1; i++)
        {   
            try
            {
                result[i] = Double.parseDouble(args[i]);
            }
        }

        return result;
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
            checker = translate_args(args,1,4);
         

            if(checker[0]==checker[1] && checker[1]==checker[2] && checker[2]==checker[3] && args[4] == "90")
            {
                return "Square";
            }
            else if (args[4]=="90")
            {
                return "Rectangle";
            }
            else
            {
                return "Rhombus";
            }

            
        }
        else if (args[0]=="C") 
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Cirlce inputs only radious");
            }
            return "Circle";
        }
        else if (args[0]=="P")
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Pentagon inputs only side size");
            }
            return "Pentagon";
        }
        else if (args[0]=="H")
        {
            if (!(args.length == 1))
            {
                throw new IllegalArgumentException("Hexagon inputs only side size");
            }
            return "Hexagon";
        }
    }
}
