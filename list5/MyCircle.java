import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;
import javafx.scene.Node;


public class MyCircle extends MyShape
{
    private Circle elipse;

    MyCircle(final double x, final double y)
    {
        super(x, y);
    }
    
    @Override
    public Node getSelf()
    {
        return elipse;
    }

    @Override 
    public boolean isInside(final double x, final double y)
    {
        return elipse.contains(x, y);
    }

    @Override
    public Paint getColor()
    {
        return elipse.getFill();
    }

    @Override
    public void setMouseClicked(EventHandler<MouseEvent> handler) //teraz mój mousehandler zajmie się przypisywaniem konkretnych handlerów w konkretnych momentach do konretnych figur, kiedy już można je upcastować
    {
        elipse.setOnMouseClicked(handler);
    }

    @Override
    public void setMousePressed(EventHandler<MouseEvent> handler)
    {
        elipse.setOnMousePressed(handler);
    }

    @Override
    public void setMouseDragged(EventHandler<MouseEvent> handler)
    {
        elipse.setOnMouseDragged(handler);
    }

    @Override
    public void setScroll(EventHandler<ScrollEvent> handler)
    {
        elipse.setOnScroll(handler);
    }

    @Override
    public void paintSelf(Color color)
    {
        elipse.setFill(color);
    }

    @Override
    public void setOutline(Paint color)
    {
        elipse.setStroke(color);
    }

    @Override
    public void rotateSelf(final double deltaAngle)
    {
        elipse.setRotate(elipse.getRotate() + deltaAngle);
    }

    @Override
    public void resizeSelf(final double deltaScale)
    {
        double newRadius = elipse.getRadius() * (1.0 + deltaScale);
        elipse.setRadius(newRadius);
    }
}
