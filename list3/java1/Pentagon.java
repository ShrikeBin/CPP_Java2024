import java.lang.Math;

public class Pentagon 
{
    private double side = 0;

    public Pentagon(double s) throws IllegalArgumentException
    {
        if(s<0)
        {
            throw new IllegalArgumentException("Side has to be at least 0, provided: "+s);
        }
        this.side = s;
    }

    public double field()
    {
        return (5/2) * (1/(Math.tan(Math.toRadians(36)))) * (side/2) * side;
    }

    public double lenght()
    {
        return 5 * side;
    }

}
