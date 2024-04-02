public final class Test 
{
    private Test() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron.");
    }

    public static void main(final String[] args)
    {   
        
        double[] test = {10.0, 10.0};

        double[] test_arr = {10.0, 10.0, 10.0, 10.0};

        double[] test_arr_rh = {10.0, 20.0, 30.0, 40.0, 50.0};


        {
        Circle c = new Circle(10);
        Hexagon h = new Hexagon(1);
        Pentagon p = new Pentagon(5);
        Square s = new Square(test_arr);
        Rhombus rh = new Rhombus(test_arr, 60.0);

        test_arr[2] = 20;
        test_arr[3] = 20;
        Rectangle r = new Rectangle(test_arr);

        assert p.lenght()==25;
        assert s.field()==100;
        assert r.lenght()==60;
        assert r.field()==200;
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
            Rectangle r = new Rectangle(test);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Square s = new Square(test);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Rectangle r = new Rectangle(test_arr_rh);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }
    }
}
