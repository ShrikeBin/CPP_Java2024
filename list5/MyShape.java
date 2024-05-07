import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.Node;


abstract class MyShape
{
    protected double x, y;

    MyShape(final double x, final double y) 
    {
        if(x<0||y<0)
        {
            throw new IllegalArgumentException("The arguments cannot be <0");
        }

        this.x = x;
        this.y = y;
    }

    abstract boolean isInside(final double x, final double y);
    
    abstract void setMouseClicked(EventHandler<MouseEvent> handler);
    abstract void setMousePressed(EventHandler<MouseEvent> handler);
    abstract void setMouseDragged(EventHandler<MouseEvent> handler);
    abstract void setScroll(EventHandler<ScrollEvent> handler);

    abstract void paintSelf(Color color);
    abstract void setOutline(Color color);
    abstract void rotateSelf(final double deltaAngle); //?hmm
    abstract void resizeSelf(final double deltaScale); //?hmm

    abstract Node getSelf();

    public double getX() 
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }
    
    public void setX(double x) 
    {
        this.x = x;
    }

    public void setY(double y) 
    {
        this.y = y;
    }

}