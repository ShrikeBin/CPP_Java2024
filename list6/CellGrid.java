import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import javafx.scene.layout.GridPane;

public class CellGrid
{
    public Object locker = new Object();
    private int width;
    private int height;
    private Cell[][] space;
    private GridPane grid = new GridPane();

    public CellGrid(int width, int height, long sleepTime, double probability) throws IllegalArgumentException
    {
        if(width < 0 || height < 0)
        {
            throw new IllegalArgumentException("CellGrid size cannot be negative, got: " + width + " , " + height);
        }

        this.width = width;
        this.height = height;

        space = new Cell[width][height];

        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                Cell cell = new Cell(sleepTime, probability, locker);
                grid.add(cell.getImage(), x, y); 
                space[x][y] = cell;
                MyLogger.logger.log(Level.FINE, "Added new Cell at: "+ x + " " + y);
            }
        }

        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                ArrayList<Cell> neighbors = new ArrayList<>(Arrays.asList(getCell(x - 1, y), getCell(x, y + 1), getCell(x + 1, y), getCell(x, y - 1)));
                getCell(x, y).setup(neighbors);
                MyLogger.logger.log(Level.FINE, "Configured new Cell at: "+ x + " " + y);
            }
        }
    }

    public Cell getCell(int x, int y) throws ClassCastException
    {
        while(x<0 || y<0)
        {
            x+= width;
            y+= height;
        }
        x = x % width;
        y = y % height;
        return space[x][y];
    }

    public void stopThreads()
    {
        for(int x = 0; x < width; ++x)
        {
            for(int y = 0; y < height; ++y)
            {
                getCell(x, y).stopThread();
                MyLogger.logger.log(Level.FINE, "Stopped Cell at: "+ x + " " + y);
            }
        }
    }

    public GridPane getGridPane()
    {
        return grid;
    }
}
