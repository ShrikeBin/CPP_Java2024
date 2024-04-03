import java.lang.Math;

public final class Pentagon extends OneParameter
{
    public Pentagon(final double s) throws IllegalArgumentException
    {
        if(s<0)
        {
            throw new IllegalArgumentException("Side has to be at least 0, provided: "+s);
        }
        parameter_one = s;
    }

    public double area()
    {
        return (5/2) * (1/(Math.tan(Math.toRadians(36)))) * (parameter_one/2) * parameter_one;
    }

    public double lenght()
    {
        return 5 * parameter_one;
    }

    public String name()
    {
        return "Pentagon";
    }

}
