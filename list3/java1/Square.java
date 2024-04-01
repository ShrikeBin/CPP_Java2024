public class Square extends Quadrilateral
{
    public Square(double[] input_sides) throws IllegalArgumentException
    {
        if (input_sides.length > 4)
        {
            throw new IllegalArgumentException("It's too many sides for a Square: " + input_sides.length);
        }

        if (input_sides.length < 4)
        {
            throw new IllegalArgumentException("It's too few sides for a Square: " + input_sides.length);
        }

        for (int i = 0; i<4; i++)
        {
            if (input_sides[i] < 0)
            {
                throw new IllegalArgumentException("Sides cannot be less than 0, provided: "+ input_sides[i]);
            }

            if (i<3 && !(input_sides[i]==input_sides[i+1]))
            {
                throw new IllegalArgumentException("This is not a Square, sides have different sizes: " + input_sides[0] + ":" + input_sides[1] + ":" + input_sides[2] + ":" + input_sides[3]);
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
