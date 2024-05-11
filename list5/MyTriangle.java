import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.lang.Math;
import java.lang.reflect.Array;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;

public class MyTriangle extends Polygon implements IMyShape
{   
    private List<Point2D> basicPoints;
    private Point2D startPoint;
    private Point2D endPoint;

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
    public void moveSelf(Point2D destination) //TODO IS BROKEN AF BUT ALMOST WORKS XDDD EVERYTHING ELSE IS FUNCTIONAL
    {   
        double startDeltaX = Math.abs(destination.getX() + startPoint.getX());
        double startDeltaY = Math.abs(destination.getY() + startPoint.getY());
        double endDeltaX = Math.abs(destination.getX() + endPoint.getX());
        double endDeltaY = Math.abs(destination.getY() + endPoint.getY());

        MyLogger.logger.log(Level.FINEST, "Destination: " + destination.getX() + " " + destination.getY());
        MyLogger.logger.log(Level.FINEST, "StartPoint: " + startDeltaX + " " + startDeltaY);
        MyLogger.logger.log(Level.FINEST, "EndPoint: " + endDeltaX + " " + endDeltaX);
        movePoints(Arrays.asList(new Point2D(startDeltaX, startDeltaY), new Point2D(endDeltaX, endDeltaY)));
    }

    
    private void movePoints(List<Point2D> points)
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
    public void setBasicPoints(List<Point2D> points)
    {
        basicPoints = points;
        if(basicPoints.size() == 2)
        {
            startPoint = points.get(0);
            endPoint = points.get(1);
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
        return contains(x, y);
    }
}
