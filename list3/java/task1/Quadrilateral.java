public abstract class Quadrilateral extends Figure
{
    protected Quadrilateral() throws InstantiationError
    {
        throw new InstantiationError("This is an abstract class you moron"); // może zostaw to puste....
    }  

    protected double[] sides = new double[4];
    protected double angle = 0;
}
