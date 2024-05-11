import java.util.logging.Level;

public class MyHandler 
{
    private MyHandler()
    {
        throw new InstantiationError("MyHandler is static class");
    }

    public static void setBasicEvents(IMyShape shape, PaintPane pane, boolean rotate) //kurde button.fire muszę dać żeby mi nie nadpi.... a nie jest ok, tylko buttony muszę sprawdzić
    {
        shape.setMousePressed(event -> 
        {
            if (!pane.getCreateMode()) 
            {
                pane.setSelectedShape(shape);
            }
        });
    
        if (!rotate)
        {
            shape.setScroll(event -> 
            {
                if (!pane.getCreateMode() && shape.equals(pane.getSelectedShape())) 
                {
                    if (event.getDeltaY() > 0) 
                    {
                        shape.resizeSelf(1.1);
                    } 
                    else
                    {
                        shape.resizeSelf(0.9);
                    }
                }
            });
        }
        else
        {
            shape.setScroll(event -> 
            {
                if (!pane.getCreateMode() && shape.equals(pane.getSelectedShape())) 
            {
                double deltaAngle = event.getDeltaY() / 10;
                shape.rotateSelf(deltaAngle);
            }
            });
        }
    }

    public static void changeEventsRotate(PaintPane pane)
    {
        for(IMyShape iter : pane.getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!pane.getCreateMode() && iter.equals(pane.getSelectedShape())) 
            {
                double deltaAngle = event.getDeltaY() / 10;
                iter.rotateSelf(deltaAngle);
            }
            });
        }
    }

    public static void changeEventsResize(PaintPane pane)
    {
        for(IMyShape iter : pane.getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!pane.getCreateMode() && iter.equals(pane.getSelectedShape())) 
                {
                    if (event.getDeltaY() > 0) 
                    {
                        iter.resizeSelf(1.1);
                    } 
                    else
                    {
                        iter.resizeSelf(0.9);
                    }
                }
            });
        }
    }
}
