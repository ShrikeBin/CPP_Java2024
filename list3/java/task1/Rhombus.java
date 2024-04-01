import java.lang.Math;

public final class Rhombus extends Quadrilateral
{
    public Rhombus(final double[] input_sides, final double angle) throws IllegalArgumentException
    {
        if (input_sides.length > 4)
        {
            throw new IllegalArgumentException("It's too many sides for a Rhombus: " + input_sides.length);
        }

        if (input_sides.length < 4)
        {
            throw new IllegalArgumentException("It's too few sides for a Rhombus: " + input_sides.length);
        }

        if (angle <= 0 || angle >= 180)
        {
            throw new IllegalArgumentException("Angle has to be greater than 0 and smaller than 180, provided: "+ angle);
        }

        for (int i = 0; i<4; i++)
        {
            if (input_sides[i] < 0)
            {
                throw new IllegalArgumentException("Sides cannot be less than 0, provided: "+ input_sides[i]);
            }

            if (i<3 && !(input_sides[i]==input_sides[i+1]))
            {
                throw new IllegalArgumentException("This is not a Rhombus, sides have different sizes: " + input_sides[0] + ":" + input_sides[1] + ":" + input_sides[2] + ":" + input_sides[3]);
            }
            
            this.sides[i] = input_sides[i];
        }

        if (angle > 90)
        {
            this.angle = 180 - angle;
        }
        else
        {
            this.angle = angle;
        }
    }

    public double field()
    {
        return (Math.sin(Math.toRadians(this.angle))) * sides[0] * sides[0];
    }

    public double lenght()
    {
        return sides[0] * 4;
    }
}
