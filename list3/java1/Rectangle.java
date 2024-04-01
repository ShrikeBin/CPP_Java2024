public class Rectangle extends Quadrilateral
{
    public Rectangle(double[] input_sides) throws IllegalArgumentException
    {
        if (input_sides.length > 4)
        {
            throw new IllegalArgumentException("It's too many sides for a Rectangle: " + input_sides.length);
        }

        for (int i = 0; i<4; i++)
        {
            if (input_sides[i] < 0)
            {
                throw new IllegalArgumentException("Sides cannot be less than 0, provided: "+ input_sides[i]);
            }

            if (i<3 && !(input_sides[i]==input_sides[i+1]))
            {
                throw new IllegalArgumentException("This is not a Rectangle");
            }
            
            this.sides[i] = input_sides[i];
        }
    }

    public double field()
    {
        return sides[0] * sides[0];
    }

    public double lenght()
    {
        return sides[0] * 4;
    }
}
