public final class Main 
{
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Usage: java Main <figure code (Q - quadrilateral, C - cirlcle, P - pentagon, H - hexagon)>; for Quadrilateral <side1> <side2> <side3> <side4> <angle>; for Circle <radious>; for Pentagon & Hexagon <side1>");
            return;
        }

        try
        {
            if(Utils.which_figure(args)=="Hexagon")
            {

            }
            if(Utils.which_figure(args)=="Pentagon")
            {
                
            }
            if(Utils.which_figure(args)=="Circle")
            {
                
            }
            if(Utils.which_figure(args)=="Rhombus")
            {
                
            }
            if(Utils.which_figure(args)=="Rectangle")
            {
                
            }
            if(Utils.which_figure(args)=="Square")
            {
                
            }
        }
        catch (final NumberFormatException e)
        {
            System.out.println(e.getStackTrace()[e.getStackTrace().length-1] + " :: " + e.getMessage());
        }
        catch (final IllegalArgumentException e)
        {
            System.out.println(e.getStackTrace()[e.getStackTrace().length-1] +" :: " + e.getMessage());
        }
    }
}
