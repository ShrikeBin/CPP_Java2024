
public class MyHandler 
{
    private MyHandler()
    {
        throw new InstantiationError("MyHandler is static class");
    }

    public static void setBasicEvents(MyShape shape, PaintPane pane)
    {
        shape.setMousePressed(event -> 
        {
            if (!pane.getCreateMode()) 
            {
                pane.setSelectedShape(shape);
            }
        });
    
        shape.setMouseDragged(event -> 
        {
            if (!pane.getCreateMode() && shape.equals(pane.getSelectedShape())) 
            {
                double newX = event.getX();
                double newY = event.getY();
                shape.setX(newX);
                shape.setY(newY);
            }
        });
    
        shape.setScroll(event -> 
        {
            if (!pane.getCreateMode() && shape.equals(pane.getSelectedShape())) 
            {
                double deltaScale = event.getDeltaY() / 100.0; // Get the deltaY of the scroll event
                shape.resizeSelf(deltaScale); // Resize the shape
            }
        });
    }

    public static void changeToDraw(PaintPane pane)
    {
        pane.setCreateMode(true);
    }

    public static void changeToMark(PaintPane pane)
    {
        pane.setCreateMode(false);
    }

    public static void changeEventsRotate(PaintPane pane)
    {
        for(MyShape iter : pane.getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!pane.getCreateMode() && iter.equals(pane.getSelectedShape())) 
            {
                double deltaAngle = event.getDeltaY();
                iter.rotateSelf(deltaAngle);
            }
            });
        }
    }

    public static void changeEventsResize(PaintPane pane)
    {
        for(MyShape iter : pane.getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!pane.getCreateMode() && iter.equals(pane.getSelectedShape())) 
                {
                    double deltaScale = event.getDeltaY() / 100.0;
                    iter.resizeSelf(deltaScale);
                }
            });
        }
    }
}
