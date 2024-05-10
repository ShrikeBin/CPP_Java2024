import javafx.scene.shape.Polygon;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;

public class MyTriangle extends Polygon implements IMyShape
{   
    private ArrayList<Point2D> basicPoints;

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
    public void setMouseDragged(EventHandler<MouseEvent> handler)
    {
        setOnMouseDragged(handler);
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
    public void moveSelf(Point2D destination)
    {
        setTranslateX(getTranslateX() + (destination.getX() - getLayoutX()));
        setTranslateY(getTranslateY() + (destination.getY() - getLayoutY()));
    }

    @Override
    public ArrayList<Point2D> getBasicPoints()
    {
        return basicPoints;
    }

    @Override
    public void setBasicPoints(ArrayList<Point2D> points)
    {
        basicPoints = points;
        if(basicPoints.size() >= 2)
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
    public Node getSelf()
    {
        return this;
    }

    @Override 
    public boolean isInside(final double x, final double y)
    {
        return contains(x, y);
    }
}
