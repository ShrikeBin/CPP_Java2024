import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public interface IMyShape
{   
    abstract void setMouseClicked(EventHandler<MouseEvent> handler);
    abstract void setMousePressed(EventHandler<MouseEvent> handler);
    abstract void setScroll(EventHandler<ScrollEvent> handler);

    abstract void paintSelf(Color color);
    abstract void setOutline(Color color);
    abstract Color getColor();

    abstract void rotateSelf(final double deltaAngle);
    abstract void resizeSelf(final double deltaScale);
    abstract void moveSelf(Point2D destination);
    abstract Shape getSelf();

    abstract List<Point2D> getBasicPoints(); 
    abstract void setBasicPoints(List<Point2D> points);
    abstract boolean isInside(final double x, final double y);

    abstract ShapeData getData();
}