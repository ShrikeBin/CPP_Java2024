public final class Rectangle extends TwoParameter
{
    public Rectangle(final double s1, final double s2) throws IllegalArgumentException
    {
        if(s1 < 0 || s2 <0)
        {
            throw new IllegalArgumentException("Sides have to be greater than 0");
        }
        parameter_one = s1;
        parameter_two = s2;
    }

    public double area()
    {
        return parameter_one*parameter_two;
    }

    public double lenght()
    {
        return (parameter_one*2)+(parameter_two*2);
    }

    public String name()
    {
        return "Rectangle";
    }
}
