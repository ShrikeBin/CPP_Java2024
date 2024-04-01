public class Rectangle extends Quadrilateral
{
    public Rectangle(double[] input_sides) throws IllegalArgumentException
    {
        if (input_sides.length > 4)
        {
            throw new IllegalArgumentException("It's too many sides for a Rectangle: " + input_sides.length);
        }

        if (input_sides.length < 4)
        {
            throw new IllegalArgumentException("It's too few sides for a Rectangle: " + input_sides.length);
        }

        for (int i = 0; i<4; i++)
        {
            if (input_sides[i] < 0)
            {
                throw new IllegalArgumentException("Sides cannot be less than 0, provided: "+ input_sides[i]);
            }
        }

        //potworek do sprawdzania czy to prostokąt :D

        double checker = input_sides[0];
        double checker_alt = 0;

        for(int i = 0; i < 4; i++)
        {
            if(!(input_sides[0]==input_sides[i]))
            {
                checker_alt = input_sides[i];
                break;
            }
        }

        int counter = 0;
        int counter_alt = 0;

        for(double index : input_sides)
        {
            if (index == checker)
            {
                counter ++;
            }

            if (index == checker_alt)
            {
                counter_alt ++;
            }
        }

        if(!(counter_alt==counter))
        {
            throw new IllegalArgumentException("This is not a Rectangle, sides have different sizes: " + input_sides[0] + ":" + input_sides[1] + ":" + input_sides[2] + ":" + input_sides[3]);
        }
        else
        {
            for(int i = 0; i < 4; i++)
            {
                sides[i] = input_sides[i];
            }
        }
    }

    public double field()
    {
        for(int i = 0; i < 4; i++)
        {
            if(!(sides[0]==sides[i]))
            {
                return sides[0]*sides[i];
            }
        }
    }

    public double lenght()
    {
        return sides[0] + sides[1] + sides[2] + sides[3];
    }
}
