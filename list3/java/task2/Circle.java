import java.lang.Math;

public final class Circle extends Figure
{
    private double radious = 0;

    public Circle(final double r) throws IllegalArgumentException
    {
        if(r<0)
        {
            throw new IllegalArgumentException("Radious has to be at least 0, provided: "+r);
        }
        this.radious = r;
    }

    public double field()
    {
        return Math.PI * Math.pow(this.radious, 2);
    }

    public double lenght()
    {
        return 2 * Math.PI * this.radious;
    }

}
