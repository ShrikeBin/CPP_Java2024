import java.util.List;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.logging.Level;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class ShapeFactory 
{
    private HashMap<String, Supplier<IMyShape>> shapeMap;

    public ShapeFactory() 
    {
        shapeMap = new HashMap<>();
    }

    public void registerShape(String codename, Supplier<IMyShape> supplier) 
    {
        shapeMap.put(codename, supplier);
    }

    public IMyShape createShape(final String codename, final List<Point2D> points, final Color color) 
    {
        Supplier<IMyShape> supplier = shapeMap.get(codename);

        if ((supplier != null)&&(points.size() == 2)) 
        {
            IMyShape shape = supplier.get();
            shape.setBasicPoints(points);
            shape.paintSelf(color);
            return shape;
        } 
        else 
        {
            MyLogger.logger.log(Level.FINE, "Unable to create shape for a codename: "+codename);
            return null;
        }
    }
}