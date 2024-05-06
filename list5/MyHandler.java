
public class MyHandler 
{
    private MyHandler()
    {
        throw new InstantiationError("MouseHandler is static class");
    }

// private void handleMouseClicked(MouseEvent event, Shape selectedShape, String shapeType) 
// {
//     double x = event.getX();
//     double y = event.getY();

//     if (selectedShape != null && selectedShape.containsPoint(x, y)) 
//     {
//         return; // Clicking inside selected shape, no new shape added
//     }

//     shapes.add(new Rectangle(x, y, 50, 50)); // Add a rectangle by default
//     redraw();
// }

// private void handleMousePressed(MouseEvent event, Shape selectedShape,List<Shape> shapeList) 
// {
//     double x = event.getX();
//     double y = event.getY();

//     for (Shape shape : shapeList) 
//     {
//         if (shape.containsPoint(x, y)) 
//         {
//             selectedShape = shape;
//             offsetX = x - selectedShape.getX();
//             offsetY = y - selectedShape.getY();

//             dragStartX = x;
//             dragStartY = y;

//             redraw();
//             return;
//         }
//     }

//     selectedShape = null;
//     redraw();
// }

// private void handleMouseDragged(MouseEvent event, Shape selectedShape) 
// {
//     if (selectedShape != null) 
//     {
//         double x = event.getX();
//         double y = event.getY();

//         if (event.isPrimaryButtonDown()) 
//         { // Move
//             selectedShape.move(x - offsetX, y - offsetY);
//         }
//         else if (event.isSecondaryButtonDown()) 
//             { // Resize
//             double diffX = x - dragStartX;
//             double diffY = y - dragStartY;

//             selectedShape.resize(diffX, diffY);
//             dragStartX = x;
//             dragStartY = y;
//         }

//         redraw();
//     }
// }

// private void redraw() 
// {
//     gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

//     for (Shape shape : shapes) {
//         shape.draw(gc);

//         if (shape == selectedShape) {
//             gc.setStroke(Color.BLUE);
//             gc.setLineWidth(2);
//             gc.strokeRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
//         }
//     }
// }
}
