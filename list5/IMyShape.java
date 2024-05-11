import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Paint;

public interface IMyShape
{   
    abstract void setMouseClicked(EventHandler<MouseEvent> handler);
    abstract void setMousePressed(EventHandler<MouseEvent> handler);
    abstract void setMouseDragged(EventHandler<MouseEvent> handler);
    abstract void setScroll(EventHandler<ScrollEvent> handler);

    abstract void paintSelf(Paint color);
    abstract void setOutline(Paint color);
    abstract Paint getColor();

    abstract void rotateSelf(final double deltaAngle);
    abstract void resizeSelf(final double deltaScale);
    abstract void moveSelf(Point2D destination);
    abstract Node getSelf();

    abstract List<Point2D> getBasicPoints(); 
    abstract void setBasicPoints(List<Point2D> points);
    abstract boolean isInside(final double x, final double y);
}