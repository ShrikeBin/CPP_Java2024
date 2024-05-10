import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaintPane extends Pane
{

    private ArrayList<IMyShape> shapeList = new ArrayList<>();
    private IMyShape selectedShape;
    private boolean createMode = false;

    PaintPane(ShapeFactory factory) //trzeba skonfigurować buttony...
    {
        super();

        setOnMouseClicked(event -> 
        {
            if (createMode) 
            {
                Color randomColor = Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));

                // Add a new shape at the clicked position
                IMyShape newShape = factory.createShape(null, null, randomColor);
                getChildren().add(newShape.getSelf());
                shapeList.add(newShape);

                // Set event handlers for the new shape
                MyHandler.setBasicEvents(newShape, this);
            } 
            else 
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
    }

    private void selectShape(IMyShape clickedShape) 
    {
        if (selectedShape != null) 
        {
            selectedShape.setOutline(selectedShape.getColor()); // dangerous cast....
            selectedShape= null;
        }

        selectedShape = clickedShape;
        selectedShape.setOutline(Color.GREEN);
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
