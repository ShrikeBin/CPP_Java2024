import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.shape.Rectangle;

public class Quadrilateral extends MyShape
{
    private Rectangle rectangle;

    Quadrilateral(final double x, final double y)
    {
        super(x, y);
    }

    @Override
    public void setMouseClicked(EventHandler<MouseEvent> handler) //teraz mój mousehandler zajmie się przypisywaniem konkretnych handlerów w konkretnych momentach do konretnych figur, kiedy już można je upcastować
    {
        rectangle.setOnMouseClicked(handler);
    }

    @Override
    public void setMousePressed(EventHandler<MouseEvent> handler)
    {
        rectangle.setOnMousePressed(handler);
    }

    @Override
    public void setMouseDragged(EventHandler<MouseEvent> handler)
    {
        rectangle.setOnMouseDragged(handler);
    }

    @Override
    public void setScroll(EventHandler<ScrollEvent> handler)
    {
        rectangle.setOnScroll(handler);
    }

    @Override
    public void paintSelf(Color color)
    {
        rectangle.setFill(color);
    }

    @Override
    public void rotateSelf(final double deltaAngle)
    {
        rectangle.setRotate(rectangle.getRotate() + deltaAngle);
    }

    @Override
    public void resizeSelf(final double deltaScale)
    {
        double newWidth = rectangle.getWidth() * (1.0 + deltaScale);
        double newHeight = rectangle.getHeight() * (1.0 + deltaScale);
        rectangle.setWidth(newWidth);
        rectangle.setHeight(newHeight);
    }
}
