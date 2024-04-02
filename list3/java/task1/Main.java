import java.lang.Math;

public final class Main 
{
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Usage: java Main <figure code (Q - quadrilateral, C - cirlcle, P - pentagon, H - hexagon)>; for Quadrilateral <side1> <side2> <side3> <side4> <angle>; for Circle <radious>; for Pentagon & Hexagon <side1> || note that all additional arguments will be ignored.");
            return;
        }

        try
        {
            if(Utils.which_figure(args)=="Hexagon")
            {
                Hexagon hex = new Hexagon(Double.parseDouble(args[0]));
                System.out.println("Hexagon, lenght: " + hex.lenght() + " area: " + hex.field());
                return;
            }
            if(Utils.which_figure(args)=="Pentagon")
            {
                Pentagon pent = new Pentagon(Double.parseDouble(args[0]));
                System.out.println("Pentagon, lenght: " + pent.lenght() + " area: " + pent.field());
                return;
            }
            if(Utils.which_figure(args)=="Circle")
            {
                Circle c = new Circle(Double.parseDouble(args[0]));
                System.out.println("Circle, lenght: " + c.lenght() + " area: " + c.field());
                return;
            }
            if(Utils.which_figure(args)=="Rhombus")
            {
                Rhombus rh = new Rhombus(Utils.translate_snippet(args, 1, 4), Double.parseDouble(args[5]));
                System.out.println("Rhombus, lenght: " + rh.lenght() + " area: " + rh.field());
                return;
            }
            if(Utils.which_figure(args)=="Rectangle")
            {
                Rectangle re = new Rectangle(Utils.translate_snippet(args, 1, 4));
                System.out.println("Rectangle, lenght: " + re.lenght() + " area: " + re.field());
                return;
            }
            if(Utils.which_figure(args)=="Square")
            {
                Square s = new Square(Utils.translate_snippet(args, 1, 4));
                System.out.println("Square, lenght: " + s.lenght() + " area: " + s.field());
                return;
            }
        }
        catch (final NumberFormatException e)
        {
            e.printStackTrace();
            return;
        }
        catch (final IllegalArgumentException e)
        {
            e.printStackTrace();
            return;
        }
    }
}
