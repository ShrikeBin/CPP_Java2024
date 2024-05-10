import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;

public class PaintPane extends Pane
{

    private ArrayList<IMyShape> shapeList = new ArrayList<>();
    private IMyShape selectedShape;
    private boolean createMode = false;
    private Line drawLine;
    private Point2D startPoint;

    PaintPane(ShapeFactory factory, ComboBox<String> shapeBox, ColorPicker colorPicker) //zmien tak zeby tworzyć tez kształty o wiecej niz 2 punktach, przepchnij handlery do góry może idk
    {
        super();

        setOnMouseClicked(event -> 
        {   
            MyLogger.logger.log(Level.FINE, "Clicked on the Pane");
            if (!createMode)
            {
                // If not in create mode, check if clicked on any shape to mark it
                for (IMyShape iter : shapeList) 
                {
                    if (iter.isInside(event.getX(), event.getY())) 
                    {
                        selectShape(iter);
                        MyLogger.logger.log(Level.FINE, "Selected a Shape");
                        break;
                    }
                }
            }
        });
        setOnMousePressed(event -> 
        {   
            if (createMode)
            {
                startPoint = new Point2D(event.getX(), event.getY());
                MyLogger.logger.log(Level.FINE, "Begun drawing");
            }
        });

        setOnMouseDragged(event ->
        {   
            if (createMode)
            {
                clearLine();
                drawLine = new Line(startPoint.getX(), startPoint.getY(), event.getX(), event.getY());
                drawLine.setStroke(Color.BLUE);
                getChildren().add(drawLine);
            }
        });

        setOnMouseReleased(event ->
        {
            if (createMode)
            {
                clearLine();
                // Add a new shape at the clicked position
                IMyShape newShape = factory.createShape(shapeBox.getValue(), new ArrayList<Point2D>(Arrays.asList(startPoint, new Point2D(event.getX(), event.getY()))), colorPicker.getValue());
                getChildren().add(newShape.getSelf());
                shapeList.add(newShape);

                // Set event handlers for the new shape
                MyHandler.setBasicEvents(newShape, this);
                MyLogger.logger.log(Level.FINE, "Finished drawing");
            }
        });
    }

    private void selectShape(IMyShape clickedShape) 
    {
        clearSelection();

        selectedShape = clickedShape;
        selectedShape.setOutline(Color.GREEN);
    }

    private void clearLine() 
    {
        if (drawLine != null) 
        {
            getChildren().remove(drawLine);
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

     public ArrayList<IMyShape> getShapeList()
    {
        return shapeList;
    }
}
