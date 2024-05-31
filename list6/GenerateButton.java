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

        setOnAction(ae ->
        {
            try
            {
                CellGrid newGrid = new CellGrid(Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), Long.parseLong(sleepTime.getText()), Double.parseDouble(probability.getText()));
                scroll.setContent(newGrid);

                if(grid != null)
                {
                    grid.stopThreads();
                }
                
                grid = newGrid;
                stage.setOnCloseRequest(we ->
                {
                    grid.stopThreads();
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
