import javafx.scene.shape.Polygon;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import java.util.List;
import java.util.logging.Level;


import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;

public class MyTriangle extends Polygon implements IMyShape
{   
    private List<Point2D> basicPoints;

    MyTriangle()
    {
        super(0, 0, 0, 0, 0, 0);
    }

    @Override
    public void setMouseClicked(EventHandler<MouseEvent> handler) //teraz mój mousehandler zajmie się przypisywaniem konkretnych handlerów w konkretnych momentach do konretnych figur, kiedy już można je upcastować
    {
        setOnMouseClicked(handler);
    }

    @Override
    public void setMousePressed(EventHandler<MouseEvent> handler) 
    {
        setOnMousePressed(handler);
    }

    @Override
    public void setScroll(EventHandler<ScrollEvent> handler)
    {
        setOnScroll(handler);
    }

    @Override
    public void paintSelf(Paint color)
    {
        setFill(color);
    }

    @Override
    public Paint getColor()
    {
        return getFill();
    }

    @Override
    public void setOutline(Paint color)
    {
        setStroke(color);
    }

    @Override
    public void rotateSelf(final double deltaAngle)
    {
        setRotate(getRotate() + deltaAngle);
    }

    @Override
    public void resizeSelf(final double deltaScale)
    {
        setScaleX(getScaleX() * deltaScale);
        setScaleY(getScaleY() * deltaScale);
    }

    @Override
    public void moveSelf(Point2D destination) //IS GOOOD
    {   
        MyLogger.logger.log(Level.FINE, "Moved: " + destination.getX() + " " + destination.getY());
        double deltaX = destination.getX() - basicPoints.get(0).getX();
        double deltaY = destination.getY() - basicPoints.get(0).getY() + ((basicPoints.get(0).getY() - basicPoints.get(1).getY())/2);
        
        setTranslateX(deltaX);
        setTranslateY(deltaY);
    }

    @Override
    public void setBasicPoints(List<Point2D> points)
    {
        basicPoints = points;
        if(basicPoints.size() == 2)
        {
            Point2D apexPoint = points.get(0);
            Point2D basePoint1 = points.get(1);
            
            // Calculate the midpoint between basePoint1 and basePoint2
            Point2D basePoint2 = new Point2D(2 * apexPoint.getX() - basePoint1.getX(), basePoint1.getY());

            // Clear the existing points and set the new points
            getPoints().clear();
            getPoints().addAll(apexPoint.getX(), apexPoint.getY(),
                               basePoint1.getX(), basePoint1.getY(),
                               basePoint2.getX(), basePoint2.getY());
        }
    }

    @Override
    public List<Point2D> getBasicPoints()
    {
        return basicPoints;
    }

    @Override
    public Node getSelf()
    {
        return this;
    }

    @Override 
    public boolean isInside(final double x, final double y)
    {
        return contains(x - this.getTranslateX(), y - this.getTranslateY());
    }
}
