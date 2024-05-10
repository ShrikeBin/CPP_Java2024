import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.geometry.Point2D;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class PaintPane extends Pane
{

    private ArrayList<IMyShape> shapeList = new ArrayList<>();
    private IMyShape selectedShape;
    private boolean createMode = false;
    private Line drawLine;
    private Point2D startPoint;

    PaintPane(ShapeFactory factory, ComboBox<String> shapeBox, ColorPicker colorPicker, DependentToggleButton rotateResize) //trzeba skonfigurować buttony...
    {
        super();

        setOnMouseClicked(event -> 
        {
            if (!createMode)
            {
                // If not in create mode, check if clicked on any shape to mark it
                for (IMyShape iter : shapeList) 
                {
                    if (iter.isInside(event.getX(), event.getY())) 
                    {
                        selectShape(iter);
                        break;
                    }
                }
            }
        });

        addEventHandler(MouseEvent.MOUSE_PRESSED, event -> 
        {   
            if (createMode)
            {
                startPoint = new Point2D(event.getX(), event.getY());
            }
        });

        addEventHandler(MouseEvent.MOUSE_DRAGGED, event ->
        {   
            if (createMode)
            {
                clearLine();
                drawLine = new Line(startPoint.getX(), startPoint.getY(), event.getX(), event.getY());
                drawLine.setStroke(Color.BLUE);
                getChildren().add(drawLine);
            }
        });

        addEventHandler(MouseEvent.MOUSE_RELEASED, event ->
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
            }
        });
    }

    private void selectShape(IMyShape clickedShape) 
    {
        if (selectedShape != null) 
        {
            selectedShape.setOutline(selectedShape.getColor());
            selectedShape= null;
        }

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

    public void changeToDraw()
    {
        createMode = true;
    }

    public void changeToMark()
    {
        createMode = false;
    }

    public ArrayList<IMyShape> getShapeList()
    {
        return shapeList;
    }
}
