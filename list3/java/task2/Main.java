public class Main 
{
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Figure Codes: SIMPLE(Sq - Square, C - Circle, P - Pentagon, H - Hexagon); COMPLEX(Re - Rectangle, Rh - Rhombus) [for simple]:java Main <code> <arg1>, [for complex]:java Main <code> <arg1> <arg2>");
            return;
        }

        try
        {

            if(Utils.isSimple(Utils.input_recognition(args)))
            {
                Factory.ShapeSimple MyShape = Creator.makeShapeSimple(Utils.input_recognition(args));
                System.out.println("Name: " + MyShape.type() + "\nArea: " + MyShape.area(Double.parseDouble(args[1]))+"\nLenght: " + MyShape.lenght(Double.parseDouble(args[1])));
            }
            else
            {
                Factory.ShapeComplex MyShape = Creator.makeShapeComplex(Utils.input_recognition(args));
                System.out.println("Name: " + MyShape.type() + "\nArea: " + MyShape.area(Double.parseDouble(args[1]), Double.parseDouble(args[2]))+"\nLenght: " + MyShape.lenght(Double.parseDouble(args[1]),Double.parseDouble(args[2])));
            }
        }
        catch (final IllegalArgumentException e)
        {
            e.printStackTrace();
            return;
        }
    }
}
