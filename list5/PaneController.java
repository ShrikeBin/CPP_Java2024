import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class PaneController 
{
    private PaintPane paintPane;

    private boolean createMode = false;
    private boolean moveShape = false;
    private boolean rotate = false;
    
    private IMyShape drawShape;
    private Point2D startPoint;
    private ShapeFactory factory;
    private IMyShape selectedShape;

    public PaneController(PaintPane paintPane, ShapeFactory factory) 
    {
        this.paintPane = paintPane;
        this.factory = factory;

        PaneHandler.setHandlers(this.paintPane, this);
    }

    public void startDrawing(Point2D startPoint) 
    {
        this.startPoint = startPoint;

        MyLogger.logger.log(Level.FINE, "Begun drawing at: " + startPoint.getX() + " " + startPoint.getY());
    }

    public void drawShape(Point2D currentPoint, String shapeType) 
    {
        clearDraw();
        drawShape = factory.createShape(shapeType, new ArrayList<>(Arrays.asList(startPoint, currentPoint)), Color.TRANSPARENT);
        drawShape.setOutline(Color.BLUE);
        paintPane.getChildren().add(drawShape.getSelf());
    }

    public void finishDrawing(Point2D endPoint, String shapeType, Color color) 
    {
        clearDraw();
        IMyShape newShape = factory.createShape(shapeType, Arrays.asList(startPoint, endPoint), color);
        paintPane.getChildren().add(newShape.getSelf());
        paintPane.getShapeList().add(newShape);
        MyHandler.setBasicEvents(newShape, this, rotate);
        this.startPoint = new Point2D(0, 0);

        MyLogger.logger.log(Level.FINE, "Finished drawing at: " + endPoint.getX() + " " + endPoint.getY());
    }

    private void clearDraw() 
    {
        if (drawShape != null) 
        {
            paintPane.getChildren().remove(drawShape.getSelf());
        }
    }

    public boolean isCreateMode() 
    {
        return createMode;
    }

    public void setCreateMode(boolean createMode) 
    {
        this.createMode = createMode;
    }

    public boolean isMoveShape() {
        return moveShape;
    }

    public void setMoveShape(boolean moveShape) 
    {
        this.moveShape = moveShape;
    }

    public boolean isRotate() 
    {
        return rotate;
    }

    public void setRotate(boolean rotate) 
    {
        this.rotate = rotate;
    }

    public IMyShape getSelectedShape() 
    {
        return selectedShape;
    }

    public void setSelectedShape(IMyShape selectedShape) 
    {
        clearSelection();

        this.selectedShape = selectedShape;

        if(selectedShape != null)
        {
            selectedShape.setOutline(Color.RED);
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

    public PaintPane getPaintPane()
    {
        return this.paintPane;
    }
}
