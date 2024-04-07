public enum Shapes
{
    SQUARE 
    {
        @Override
        public double circ()
        {
            return 4 * var1;
        }
    },
    HEXAGON 
    {
        @Override
        public double circ()
        {
            return 6 * var1;
        }
    };

    private double var1;
    public abstract double circ();

    public void setVar1(double var1) 
    {
        this.var1 = var1;
    }

    public double getVar1() 
    {
        return var1;
    }

}