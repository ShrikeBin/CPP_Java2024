
public class MyHandler 
{
    private MyHandler()
    {
        throw new InstantiationError("MouseHandler is static class");
    }

    public static void setBasicEvents(MyShape shape, PaintPane pane)
    {
        //nadpisywanie selecta, obrót i resize i poruszanie
        shape.setMousePressed(event -> 
        {
            if (!pane.createMode()) 
            {
                pane.setSelectedShape(shape);
            }
        });
    
        shape.setMouseDragged(event -> 
        {
            if (!pane.createMode() && shape.equals(pane.getSelectedShape())) 
            {
                double newX = event.getX();
                double newY = event.getY();
                shape.setX(newX);
                shape.setY(newY);
            }
        });
    
        shape.setScroll(event -> 
        {
            if (!pane.createMode() && shape.equals(pane.getSelectedShape())) 
            {
                double deltaScale = event.getDeltaY() / 100.0; // Get the deltaY of the scroll event
                shape.resizeSelf(deltaScale); // Resize the shape
            }
        });
    }
}
