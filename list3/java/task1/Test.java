public final class Test 
{
    private Test() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron.");
    }

    public static void main(final String[] args)
    {   
        
        double[] test = new double[2];
        test[0] = 10.0;
        test[1] = 10.0;

        double[] test_arr = new double[4];
        test_arr[0] = 10.0;
        test_arr[1] = 10.0;
        test_arr[2] = 10.0;
        test_arr[3] = 10.0;

        double[] test_arr_rh = new double[5];
        test_arr_rh[0] = 10.0;
        test_arr_rh[1] = 20.0;
        test_arr_rh[2] = 30.0;
        test_arr_rh[3] = 40.0;
        test_arr_rh[4] = 50.0;

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
