import java.util.logging.Level;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GenerateButton extends Button
{
    private CellGrid grid;

    public GenerateButton(Stage stage, ScrollPane scroll, TextField width, TextField height, TextField sleepTime, TextField probability)
    {
        super("Generate");

        grid = null;

        setOnAction(event ->
        {
            try
            {
                if (grid != null) 
                {
                    grid.stopThreads();
                }

                int gridWidth = Integer.parseInt(width.getText());
                int gridHeight = Integer.parseInt(height.getText());
                long cellSleepTime = Long.parseLong(sleepTime.getText());
                double cellProbability = Double.parseDouble(probability.getText());

                CellGrid newGrid = new CellGrid(gridWidth, gridHeight, cellSleepTime, cellProbability);
                scroll.setContent(newGrid.getGridPane());
                grid = newGrid;
                MyLogger.logger.log(Level.FINE, "Created new Grid");
   
                stage.setOnCloseRequest(we ->
                {
                    if (grid != null)
                    {
                        grid.stopThreads();
                    }
                });
            }
            catch(NumberFormatException e)
            {
                ErrorHandler.showError("Invalid Data", "Data should be of type:\nwidth[int], height[int], sleepTime[long] (in ms), probability[double].(0-100)%");
                MyLogger.logger.log(Level.FINE, "exception occured", e);
            }
            catch(IllegalArgumentException e)
            {
                ErrorHandler.showError("Invalid Data", e.getMessage());
                MyLogger.logger.log(Level.FINE, "exception occured", e);
            }
        });
    }

    public CellGrid getCellGrid()
    {
        return grid;
    }
}
