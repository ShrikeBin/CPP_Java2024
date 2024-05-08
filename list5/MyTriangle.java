import javafx.scene.shape.Polygon;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.paint.Paint;

public class MyTriangle extends MyShape
{
    private Polygon triangle;
    
    MyTriangle(final double x, final double y)
    {
        super(x,y);
    }

    @Override
    public Node getSelf()
    {
        return triangle;
    }

    @Override 
    public boolean isInside(final double x, final double y)
    {
        return triangle.contains(x, y);
    }

    @Override
    public Paint getColor()
    {
        return triangle.getFill();
    }

    @Override
    public void setMouseClicked(EventHandler<MouseEvent> handler)
    {
        triangle.setOnMouseClicked(handler);
    }

    @Override
    public void setMousePressed(EventHandler<MouseEvent> handler)
    {
        triangle.setOnMousePressed(handler);
    }

    @Override
    public void setMouseDragged(EventHandler<MouseEvent> handler)
    {
        triangle.setOnMouseDragged(handler);
    }

    @Override
    public void setScroll(EventHandler<ScrollEvent> handler)
    {
        triangle.setOnScroll(handler);
    }

    @Override
    public void paintSelf(Color color)
    {
        triangle.setFill(color);
    }

    @Override
    public void setOutline(Color color)
    {
        triangle.setStroke(color);
    }

    @Override
    public void rotateSelf(final double deltaAngle)
    {
        triangle.setRotate(triangle.getRotate() + deltaAngle);
    }

    @Override
    public void resizeSelf(final double deltaScale)
    {
        // for (int i = 0; i < triangle.getPoints().size(); i++) //weź to sprawdź jeszcze xd no ofc nie dział, jak zrobić resize dobrze?????
        // {
        //     double newValue = triangle.getPoints().get(i) * (1.0 + deltaScale);
        //     triangle.getPoints().set(i, newValue);
        // }
    }
}

