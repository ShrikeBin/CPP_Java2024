import javafx.geometry.Point2D;
import java.util.List;

public class Delta 
{
    private Delta()
    {
        throw new InstantiationError("Static class");
    }

    public static Point2D calculate(Point2D destination, List<Point2D> basicPoints) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX();
        double deltaY = destination.getY() - basicPoints.get(0).getY() + ((basicPoints.get(0).getY() - basicPoints.get(1).getY()) / 2);

        return new Point2D(deltaX, deltaY);
    }
}

