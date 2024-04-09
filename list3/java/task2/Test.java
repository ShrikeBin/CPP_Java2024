public final class Test 
{
    private Test() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron");
    }
    
    public static void main(final String[] args)
    {
        {
        Circle c = new Circle(10);
        Hexagon h = new Hexagon(1);
        Pentagon p = new Pentagon(5);
        Square s = new Square(10);
        Rhombus rh = new Rhombus(10, 90);
        Rectangle r = new Rectangle(10,20);

        assert p.lenght()==25;
        assert s.area()==100;
        assert r.lenght()==60;
        assert r.area()==200;
        }
        
        try
        {
            Circle c = new Circle(-10);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Rhombus rh = new Rhombus(10, 280);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Factory.ShapeSimple a = Creator.makeShapeSimple("pies");
            Factory.ShapeSimple b = Creator.makeShapeSimple("rhombus");
            Factory.ShapeSimple c = Creator.makeShapeSimple("rectangle");
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Factory.ShapeComplex d = Creator.makeShapeComplex("pies");
            Factory.ShapeComplex e = Creator.makeShapeComplex("square");
            Factory.ShapeComplex f = Creator.makeShapeComplex("circle");
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }
    }
}
