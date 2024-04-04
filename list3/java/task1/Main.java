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
            Figure[] Test = new Figure[1];

            switch (Utils.which_figure(args)) 
            {
                case "Hexagon":
                    Test[0] = new Hexagon(Double.parseDouble(args[0]));
                    break;
                case "Pentagon":
                    Test[0] = new Pentagon(Double.parseDouble(args[0]));
                    break;
                case "Circle":
                    Test[0] = new Circle(Double.parseDouble(args[0]));
                    break;
                case "Rhombus":
                    Test[0] = new Rhombus(Utils.translate_snippet(args, 1, 4), Double.parseDouble(args[5]));
                    break;
                case "Rectangle":
                    Test[0] = new Rectangle(Utils.translate_snippet(args, 1, 4));
                    break;
                case "Square":
                    Test[0] = new Square(Utils.translate_snippet(args, 1, 4));
                    break;
                default:
                    break;
            }
            
            System.out.println(Utils.which_figure(args) + ", lenght: " + Test[0].lenght() + " area: " + Test[0].field());

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
