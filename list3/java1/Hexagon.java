import java.lang.Math;

public class Hexagon extends Figure
{
    private double side = 0;

    public Hexagon(double s) throws IllegalArgumentException
    {
        if(s<0)
        {
            throw new IllegalArgumentException("Side has to be at least 0, provided: "+s);
        }
        this.side = s;
    }

    public double field()
    {
        return (Math.sqrt(3) * side) * side * 3;
    }

    public double lenght()
    {
        return 6 * side;
    }
}
