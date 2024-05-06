import java.util.HashMap;
import java.util.function.Supplier;
import java.util.logging.Level;

//  jak dorzucać kształty?
//  ShapeFactory factory = new ShapeFactory
//  factory.registerShape("circle", ()-> new Circle())  
// to znaczy to samo jak gdybym zrobił 

// factory.registerShape("circle", new Supplier<MyShape>()
// {
//     @Override 
//     public MyShape get()
//     { 
//         return new Circle();
//     }
// })

//  o w ten sposób

public class ShapeFactory 
{
    private HashMap<String, Supplier<MyShape>> shapeMap;

    public ShapeFactory() 
    {
        shapeMap = new HashMap<>();
    }

    public void registerShape(String codename, Supplier<MyShape> supplier) 
    {
        shapeMap.put(codename, supplier);
    }

    public MyShape createShape(final String codename, final double x, final double y) 
    {
        Supplier<MyShape> supplier = shapeMap.get(codename);

        if (supplier != null) 
        {
            MyShape shape = supplier.get();
            shape.setX(x);
            shape.setY(y);
            return shape;
        } 
        else 
        {
            MyLogger.logger.log(Level.FINE, "Unable to create shape for a codename: "+codename);
            return null;
        }
    }

}
