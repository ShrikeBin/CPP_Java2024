import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaintPane extends Pane
{

    private ArrayList<MyShape> shapeList = new ArrayList<>();
    private MyShape selectedShape;
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
                MyShape newShape = factory.createShape(null,event.getX(), event.getY(), randomColor);
                getChildren().add(newShape.getSelf());
                shapeList.add(newShape);

                // Set event handlers for the new shape using created PaintPane
                MyHandler.setBasicEvents(newShape, this);
            } 
            else 
            {
                // If not in create mode, check if clicked on any shape to mark it
                for (MyShape iter : shapeList) 
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

    private void selectShape(MyShape clickedShape) 
    {
        clearSelection();
        selectedShape = clickedShape;
        selectedShape.setOutline(Color.GREEN);
    }

    private void clearSelection() 
    {
        if (selectedShape != null) 
        {
            selectedShape.setOutline(Color.BLACK);
            selectedShape= null;
        }
    }

    public MyShape getSelectedShape()
    {
        return selectedShape;
    }

    public void setSelectedShape(MyShape shape)
    {
        selectShape(shape);
    }

    public boolean createMode()
    {
        return createMode;
    }
}
