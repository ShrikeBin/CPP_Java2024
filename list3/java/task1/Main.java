public final class Main 
{
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Usage: java Main <figure code (Q - quadrilateral, C - cirlcle, P - pentagon, H - hexagon)>; for Quadrilateral <side1> <side2> <side3> <side4> <angle>; for Circle <radious>; for Pentagon & Hexagon <side1>");
            return;
        }

        if(args[0]=="Q")
        {

        }
        else if (args[0]=="C") 
        {
            
        }
        else if (args[0]=="P")
        {

        }
        else if (args[0]=="H")
        {

        }
        else
        {
            System.out.println("Unable to recognize figure code"); // parseDouble NumberFormatException
        }
    }
}
