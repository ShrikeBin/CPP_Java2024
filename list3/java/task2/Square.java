public final class Square extends OneParameter
{
    public Square(final double input) throws IllegalArgumentException
    {
        if (input < 0) 
        {
            throw new IllegalArgumentException("Sides can't be less than 0");
        }
        parameter_one = input;
    }

    public double area()
    {
        return parameter_one*parameter_one;
    }

    public double lenght()
    {
        return parameter_one * 4;
    }
    
    public String name()
    {
        return "Square";
    }
}
