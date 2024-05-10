import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;
import javafx.scene.Node;


public class MyCircle extends Circle implements IMyShape
{
    private ArrayList<Point2D> basicPoints;
    MyCircle(ArrayList<Point2D> points)
    {
        basicPoints = points;
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
        setCenterX(destination.getX());
        setCenterY(destination.getY());
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
