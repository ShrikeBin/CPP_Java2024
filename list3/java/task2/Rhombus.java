import java.lang.Math;

public final class Rhombus extends TwoParameter
{
    public Rhombus(final double s1, final double angle) throws IllegalArgumentException
    {
        if(s1 < 0 || angle < 0 || angle > 180)
        {
            throw new IllegalArgumentException("Invalid inputs for Rhombus");
        }

        if (angle > 90)
        {
            parameter_two = 180 - angle;
        }
        else
        {
            parameter_two = angle;
        }

        parameter_one = s1;

    }

    public double area()
    {   
        return (Math.sin(Math.toRadians(parameter_two))) * parameter_one * parameter_one;
    }

    public double lenght()
    {
        return parameter_one * 4;
    }

    public String name()
    {
        return "Rhombus";
    }
}
