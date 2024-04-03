import java.lang.Math;

public final class Hexagon extends OneParameter
{
    public Hexagon(final double s) throws IllegalArgumentException
    {
        if(s<0)
        {
            throw new IllegalArgumentException("Side has to be at least 0, provided: "+s);
        }
        parameter_one = s;
    }

    public double area()
    {
        return (Math.sqrt(3) * parameter_one) * parameter_one * 3;
    }

    public double lenght()
    {
        return 6 * parameter_one;
    }

    public String name()
    {
        return "Hexagon";
    }
}
