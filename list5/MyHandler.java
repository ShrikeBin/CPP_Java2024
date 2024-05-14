public class MyHandler 
{
    private MyHandler()
    {
        throw new InstantiationError("MyHandler is static class");
    }

    public static void setBasicEvents(IMyShape shape, PaneController paneController, boolean rotate)
    {
        shape.setMouseClicked(event -> 
        {
            if (!paneController.isCreateMode()) 
            {
                paneController.setSelectedShape(shape);
            }
        });

        //added to ensure start of moving Shape
        shape.setMousePressed(event ->
        {
            if (shape.equals(paneController.getSelectedShape())) 
            {
                paneController.setMoveShape(true);;
            }
        });
    
        if (!rotate)
        {
            shape.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && shape.equals(paneController.getSelectedShape())) 
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
                if (!paneController.isCreateMode() && shape.equals(paneController.getSelectedShape())) 
            {
                double deltaAngle = event.getDeltaY() / 10;
                shape.rotateSelf(deltaAngle);
            }
            });
        }
    }

    public static void changeEventsRotate(PaneController paneController)
    {
        for(IMyShape iter : paneController.getPaintPane().getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && iter.equals(paneController.getSelectedShape())) 
                {
                    double deltaAngle = event.getDeltaY() / 10;
                    iter.rotateSelf(deltaAngle);
                }
            });
        }
    }

    public static void changeEventsResize(PaneController paneController)
    {
        for(IMyShape iter : paneController.getPaintPane().getShapeList())
        {
            iter.setScroll(event -> 
            {
                if (!paneController.isCreateMode() && iter.equals(paneController.getSelectedShape())) 
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
