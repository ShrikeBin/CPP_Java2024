import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;

public class CellGrid extends GridPane
{
    private int width;
    private int height;

    public CellGrid(int width, int height, long sleepTime, double probability, ColorPicker picker) throws IllegalArgumentException
    {
        if(width < 0 || height < 0)
        {
            throw new IllegalArgumentException("CellGrid size cannot be negative, got: " + width + " , " + height);
        }

        this.width = width;
        this.height = height;

        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                add(new Cell(sleepTime, probability), x, y);
            }
        }

        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                ArrayList<CellStatus> neighbors = new ArrayList<>(Arrays.asList(getCell(x - 1, y), getCell(x, y + 1), getCell(x + 1, y), getCell(x, y - 1)));
                getCell(x, y).setup(neighbors, picker);
            }
        }
    }

    public Cell getCell(int x, int y) throws ClassCastException
    {
        x = x % width;
        y = y % height;

        if(x < 0)
        {
            x += width;
        }
        if(y < 0)
        {
            y += height;
        }

        return (Cell)getChildren().get(x * height + y);
    }

    public void stopThreads()
    {
        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                getCell(x, y).stopThread();
            }
        }
    }
}
