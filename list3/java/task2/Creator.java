public final class Creator 
{
    private Creator() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron");
    }
    
    public static Factory.ShapeSimple makeShapeSimple(String type)
    {
        switch(type)
        {
            case "Square":
                return Factory.ShapeSimple.SQUARE;
            case "Circle":
                return Factory.ShapeSimple.CIRCLE;
            case "Pentagon":
                return Factory.ShapeSimple.PENTAGON;
            case "Hexagon":
                return Factory.ShapeSimple.HEXAGON;
            default:
                throw new IllegalArgumentException("Invalid object type");
        }
    }
    
    public static Factory.ShapeComplex makeShapeComplex(String type)
    {
        switch(type)
        {
            case "Rectangle":
                return Factory.ShapeComplex.RECTANGLE;
            case "Rhombus":
                return Factory.ShapeComplex.RHOMBUS;
            default:
                throw new IllegalArgumentException("Invalid object type");
        }
    }
}
