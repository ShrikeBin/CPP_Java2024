import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * PaneController manages the interactions and logic for the PaintPane,
 * including creating, moving, rotating, and selecting shapes.
 */
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

    /**
     * Constructs a PaneController for the specified PaintPane and ShapeFactory.
     *
     * @param paintPane The PaintPane to control.
     * @param factory The ShapeFactory to create shapes.
     */
    public PaneController(PaintPane paintPane, ShapeFactory factory) 
    {
        this.paintPane = paintPane;
        this.factory = factory;
        PaneHandler.setHandlers(this.paintPane, this);
    }

    /**
     * Starts drawing a shape from the specified start point.
     *
     * @param startPoint The starting point of the shape.
     */
    public void startDrawing(Point2D startPoint) 
    {
        this.startPoint = startPoint;
        MyLogger.logger.log(Level.FINE, "Begun drawing at: " + startPoint.getX() + " " + startPoint.getY());
    }

    /**
     * Draws a shape from the start point to the current point.
     *
     * @param currentPoint The current point of the shape.
     * @param shapeType The type of shape to draw.
     */
    public void drawShape(Point2D currentPoint, String shapeType) 
    {
        clearDraw();
        drawShape = factory.createShape(shapeType, new ArrayList<>(Arrays.asList(startPoint, currentPoint)), Color.TRANSPARENT);
        drawShape.setOutline(Color.BLUE);
        paintPane.getChildren().add(drawShape.getSelf());
    }

    /**
     * Finishes drawing a shape at the specified end point and sets its color.
     *
     * @param endPoint The ending point of the shape.
     * @param shapeType The type of shape to draw.
     * @param color The color of the shape.
     */
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

    /**
     * Clears the current shape being drawn.
     */
    private void clearDraw() 
    {
        if (drawShape != null) 
        {
            paintPane.getChildren().remove(drawShape.getSelf());
        }
    }

    /**
     * Checks if the controller is in create mode.
     *
     * @return True if in create mode, false otherwise.
     */
    public boolean isCreateMode() 
    {
        return createMode;
    }

    /**
     * Sets the create mode.
     *
     * @param createMode True to enable create mode, false to disable.
     */
    public void setCreateMode(boolean createMode) 
    {
        this.createMode = createMode;
    }

    /**
     * Checks if a shape is currently being moved.
     *
     * @return True if a shape is being moved, false otherwise.
     */
    public boolean isMoveShape() 
    {
        return moveShape;
    }

    /**
     * Sets the move shape state.
     *
     * @param moveShape True to enable moving shapes, false to disable.
     */
    public void setMoveShape(boolean moveShape) 
    {
        this.moveShape = moveShape;
    }

    /**
     * Checks if the rotate mode is enabled.
     *
     * @return True if rotate mode is enabled, false otherwise.
     */
    public boolean isRotate() 
    {
        return rotate;
    }

    /**
     * Sets the rotate mode.
     *
     * @param rotate True to enable rotate mode, false to disable.
     */
    public void setRotate(boolean rotate) 
    {
        this.rotate = rotate;
    }

    /**
     * Gets the currently selected shape.
     *
     * @return The selected shape.
     */
    public IMyShape getSelectedShape() 
    {
        return selectedShape;
    }

    /**
     * Sets the selected shape and updates its outline.
     *
     * @param selectedShape The shape to select.
     */
    public void setSelectedShape(IMyShape selectedShape) 
    {
        clearSelection();
        this.selectedShape = selectedShape;
        if (selectedShape != null) 
        {
            selectedShape.setOutline(Color.RED);
        }
    }

    /**
     * Clears the selection of the currently selected shape.
     */
    public void clearSelection() 
    {
        if (selectedShape != null) 
        {
            selectedShape.setOutline(selectedShape.getColor());
            selectedShape = null;
        }
    }

    /**
     * Gets the PaintPane managed by this controller.
     *
     * @return The PaintPane.
     */
    public PaintPane getPaintPane() 
    {
        return this.paintPane;
    }
}
