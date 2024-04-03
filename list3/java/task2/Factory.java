public final class Factory 
{   
    private Factory() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron");
    }

    public enum ShapeSimple implements Shape_simple
    {
        CIRCLE, SQUARE, PENTAGON, HEXAGON;

        public double area(final double var1)
        {
            return create(var1).area();
        }
        public double lenght(final double var1)
        {
            return create(var1).lenght();
        }
        public String type()
        {
            return create(1).name();
        }
        private Methods create(final double var1)
        {
            switch(this)
            {
                case CIRCLE:
                    return new Circle(var1);
                case SQUARE:
                    return new Square(var1);
                case PENTAGON:
                    return new Pentagon(var1);
                case HEXAGON:
                    return new Hexagon(var1);
                default:
                    throw new IllegalArgumentException("Unable to recognize figure");
            }
        }
    }

    public enum ShapeComplex implements Shape_complex
    {
        RHOMBUS, RECTANGLE;

        public  double area(final double var1, final double var2)
        {
            return create(var1, var2).area();
        }
        public  double lenght(final double var1, final double var2)
        {
            return create(var1, var2).lenght();
        }
        public String type()
        {
            return create(1, 1).name();
        }
        private Methods create(final double var1, final double var2)
        {
            switch(this)
            {
                case RECTANGLE:
                    return new Rectangle(var1, var2);
                case RHOMBUS:
                    return new Rhombus(var1, var2);
                default:
                    throw new IllegalArgumentException("Unable to recognize figure");
            }
        }
    }
}
