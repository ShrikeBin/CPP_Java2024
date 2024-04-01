import java.util.Arrays;

public final class Rectangle extends Quadrilateral
{
    public Rectangle(final double[] input_sides) throws IllegalArgumentException
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

        
        double checker[] = new double[4];

        for(int i = 0; i < 4; i++)
        {
            checker[i] = input_sides[i];
        }

        Arrays.sort(checker);

        if(!((checker[0]==checker[1])&&(checker[2]==checker[3])))
        {
            throw new IllegalArgumentException("This is not a Rectangle, sides have different sizes: " + input_sides[0] + ":" + input_sides[1] + ":" + input_sides[2] + ":" + input_sides[3]);
        }

        for(int i = 0; i < 4; i++)
        {
            this.sides[i] = checker[i];
        }
    }

    public double field()
    {
        return sides[0]*sides[2];
    }

    public double lenght()
    {
        return sides[0] + sides[1] + sides[2] + sides[3];
    }
}
