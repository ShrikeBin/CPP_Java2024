import java.lang.Math;

public final class Circle extends OneParameter
{
    public Circle(final double r) throws IllegalArgumentException
    {
        if(r<0)
        {
            throw new IllegalArgumentException("Radious has to be at least 0, provided: "+r);
        }
        parameter_one = r;
    }

    public double area()
    {
        return Math.PI * Math.pow(parameter_one, 2);
    }

    public double lenght()
    {
        return 2 * Math.PI * parameter_one;
    }

    public String name()
    {
        return "Circle";
    }
}
