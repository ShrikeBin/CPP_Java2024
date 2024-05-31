import java.util.ArrayList;
import java.util.logging.Level;
import java.lang.Math;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle implements Runnable, CellStatus
{
    private static final ColorRandomiser random = new ColorRandomiser();

    private final long sleepTime;
    private final double randomColorProbability;

    private ArrayList<CellStatus> neighbors;
    private final Thread thread;
    private boolean active;

    private boolean running;

    public Cell(long sleepTime, double randomColorProbability) throws IllegalArgumentException
    {
        super(30, 30, random.nextColor());

        if(sleepTime <= 0)
        {
            throw new IllegalArgumentException("Cell sleep time must be positive, got: " + sleepTime);
        }

        if(randomColorProbability < 0 || randomColorProbability > 100)
        {
            throw new IllegalArgumentException("Cell probability has to be > 0 and < 100 got: " + randomColorProbability);
        }

        this.sleepTime = sleepTime;
        this.randomColorProbability = randomColorProbability;

        thread = new Thread(this);
        neighbors = null;
        active = false;

        running = true;

        thread.start();
    }

    public void setup(ArrayList<CellStatus> neighbors)
    {
        this.neighbors = neighbors;
        active = true;
        
        this.setOnMouseClicked(event ->
        {
            active = !active;
            if(!active)
            {
                setStroke(Color.BLACK); //każdy wątek ma też setować stroke'a (dodaj to)
            }
            MyLogger.logger.log(Level.INFO, "Cell clicked");
        });
    }

    public void stopThread()
    {
        running = false;
    }

    public boolean getActive()
    {
        return active;
    }

    public void setActive(boolean input)
    {
        active = input;
    }

    public Color getColor()
    {
        try
        {
            Color output = (Color)getFill();
            return output;
        }
        catch(ClassCastException e)
        {
            ErrorHandler.showError("Unable to read color data", "Unable to read color data in a cell");
            return new Color(0, 0, 0, 0);
        }
    }

    public Cell getSelf()
    {
        return this;
    }

    @Override
    public void run()
    {
        while(running)
        {
            try
            {
                Thread.sleep(random.nextLong(sleepTime) + (long)(sleepTime * 0.5));
            }
            catch(InterruptedException e)
            {
                ErrorHandler.showError("Thread Interruption error", "Thread nr " + thread.threadId() + " has been interrupted.");
            }

            if(active)
            {
                Platform.runLater(() ->
                {
                    ThreadLogger.logStart(thread);

                    if(random.nextDouble(100.0 + Math.ulp(100.0d)) <= randomColorProbability)
                    {
                        Color period = random.nextColor();
                        setFill(period);
                        setStroke(period);
                    }
                    else
                    {
                        double avgRed = 0;
                        double avgGreen = 0;
                        double avgBlue = 0;
                        int count = 0;

                        for(CellStatus iter : neighbors)
                        {
                            if(iter != null && iter.getActive())
                            {
                                avgRed += iter.getColor().getRed();
                                avgGreen += iter.getColor().getGreen();
                                avgBlue += iter.getColor().getBlue();
                                ++count;
                            }
                        }

                        if(count != 0)
                        {
                            setFill(new Color(avgRed / count, avgGreen / count, avgBlue / count, 1.0));
                            setStroke(new Color(avgRed / count, avgGreen / count, avgBlue / count, 1.0));
                        }
                    }

                    ThreadLogger.logEnd(thread);
                });
            }
        }
    }

    
}
