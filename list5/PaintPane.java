import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;

public class PaintPane extends Pane
{

    private ArrayList<IMyShape> shapeList = new ArrayList<>();
    private IMyShape selectedShape;
    private boolean createMode = false;
    private boolean moveShape = false;
    private boolean rotate = false;
    private IMyShape drawShape;
    private Point2D startPoint;

    PaintPane(ShapeFactory factory, ComboBox<String> shapeBox, ColorPicker colorPicker) //dodaj guzik na delete selectedShape
    {
        super();

        setOnMouseClicked(event -> 
        {   
            MyLogger.logger.log(Level.FINE, "Clicked on the Pane at: " + event.getX() + " " + event.getY());
        });

        setOnMousePressed(event -> 
        {   
            MyLogger.logger.log(Level.FINE, "Pressed on the Pane at: " + event.getX() + " " + event.getY());
            if (createMode)
            {
                startPoint = new Point2D(event.getX(), event.getY());
                MyLogger.logger.log(Level.FINE, "Begun drawing at: " + event.getX() + " " + event.getY());
            }
        });

        setOnMouseDragged(event ->
        {   
            if (createMode)
            {
                clearDraw();
                drawShape = factory.createShape(shapeBox.getValue(), new ArrayList<Point2D>(Arrays.asList(startPoint, new Point2D(event.getX(), event.getY()))), Color.TRANSPARENT);
                drawShape.setOutline(Color.BLUE);
                getChildren().add(drawShape.getSelf());
            }
            else if (selectedShape != null && moveShape)
            {
                selectedShape.moveSelf(new Point2D(event.getX(), event.getY()));
            }
        });

        setOnMouseReleased(event ->
        {
            MyLogger.logger.log(Level.FINE, "Released on the Pane at: " + event.getX() + " " + event.getY());
            if (createMode)
            {
                clearDraw();
                // Add a new shape at the clicked position
                IMyShape newShape = factory.createShape(shapeBox.getValue(), Arrays.asList(startPoint, new Point2D(event.getX(), event.getY())), colorPicker.getValue());
                getChildren().add(newShape.getSelf());
                shapeList.add(newShape);

                // Set event handlers for the new shape
                MyHandler.setBasicEvents(newShape, this, rotate);
                MyLogger.logger.log(Level.FINE, "Finished drawing at: "+ event.getX() + " " + event.getY());
            }
            else if (selectedShape != null && moveShape)
            {
                MyLogger.logger.log(Level.FINE, "Stopped moving at: " + event.getX() + " " + event.getY());
                moveShape = false;
            }
        });
    }

    private void selectShape(IMyShape clickedShape) 
    {
        clearSelection();

        selectedShape = clickedShape;
        selectedShape.setOutline(Color.GREEN);
    }

    private void clearDraw() 
    {
        if (drawShape != null) 
        {
            getChildren().remove(drawShape.getSelf());
        }
    }

    public void clearSelection()
    {
        if (selectedShape != null) 
        {
            selectedShape.setOutline(selectedShape.getColor());
            selectedShape= null;
        }
    }

    public IMyShape getSelectedShape()
    {
        return selectedShape;
    }

    public void setSelectedShape(IMyShape shape)
    {
        selectShape(shape);
    }

    public boolean getCreateMode()
    {
        return createMode;
    }

    public void setCreateMode(boolean input)
    {
        createMode = input;
    }

    public boolean getMoveShape() 
    {
        return moveShape;
    }
    
    public void setMoveShape(boolean input) 
    {
        moveShape = input;
    }
    

     public ArrayList<IMyShape> getShapeList()
    {
        return shapeList;
    }

    public void setRotateHandle(boolean input)
    {
        rotate = input;
    }
}
