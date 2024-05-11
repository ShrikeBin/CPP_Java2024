import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Paint;

import java.util.List;
import java.lang.Math;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;

public class MyRectangle extends Rectangle implements IMyShape
{
    private List<Point2D> basicPoints;

    MyRectangle()
    {
        super(0, 0, 0, 0);
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
    public void moveSelf(Point2D destination)
    {
        setX(destination.getX() - (getWidth()/2));
        setY(destination.getY() - (getHeight()/2));
    }

    @Override
    public List<Point2D> getBasicPoints()
    {
        return basicPoints;
    }

    @Override
    public void setBasicPoints(List<Point2D> points)
    {
        basicPoints = points;
        if (basicPoints.size() >= 2) 
        {
            // Set properties of the rectangle
            setX(Math.min(basicPoints.get(0).getX(), basicPoints.get(1).getX()));
            setY(Math.min(basicPoints.get(0).getY(), basicPoints.get(1).getY()));
            setWidth(Math.abs(basicPoints.get(1).getX() - basicPoints.get(0).getX()));
            setHeight(Math.abs(basicPoints.get(1).getY() - basicPoints.get(0).getY()));
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
