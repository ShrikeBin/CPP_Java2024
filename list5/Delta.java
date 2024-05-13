import javafx.geometry.Point2D;
import java.util.List;

public class Delta 
{
    private Delta()
    {
        throw new InstantiationError("Static class");
    }

    public static Point2D calculateTriangle(Point2D destination, List<Point2D> basicPoints) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX();
        double deltaY = destination.getY() - basicPoints.get(0).getY() + ((basicPoints.get(0).getY() - basicPoints.get(1).getY()) / 2);

        return new Point2D(deltaX, deltaY);
    }

    public static Point2D calculateEllipse(Point2D destination, List<Point2D> basicPoints) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX();
        double deltaY = destination.getY() - basicPoints.get(0).getY();

        return new Point2D(deltaX, deltaY);
    }

    public static Point2D calculateRectangle(Point2D destination, List<Point2D> basicPoints, MyRectangle rectangle) 
    {
        double deltaX = destination.getX() - basicPoints.get(0).getX() - rectangle.getWidth()/2;
        double deltaY = destination.getY() - basicPoints.get(0).getY() - rectangle.getHeight()/2;

        return new Point2D(deltaX, deltaY);
    }
}

