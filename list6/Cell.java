import java.util.ArrayList;
import java.util.logging.Level;
import java.lang.Math;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell implements Runnable
{
    private static final ColorRandomiser random = new ColorRandomiser();
    private Rectangle image = new Rectangle();
    private Object locker;

    private final long sleepTime;
    private final double randomColorProbability;

    private ArrayList<Cell> neighbors;
    private final Thread thread;
    private boolean active;
    private boolean running;

    public Cell(long sleepTime, double randomColorProbability, Object locker) throws IllegalArgumentException
    {
        image = new Rectangle(30, 30, random.nextColor());
        image.setStrokeWidth(2);
        this.locker = locker;
        
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
        neighbors = new ArrayList<Cell>();
        active = false;
    }

    public void setup(ArrayList<Cell> neighbors)
    {
        this.neighbors = neighbors;
        active = true;
        
        image.setOnMouseClicked(event ->
        {
            setActive(!active);
            if(!active)
            {
                image.setStroke(Color.BLACK);
            }
            MyLogger.logger.log(Level.INFO, "Cell clicked");
            System.out.println("Thread clicked: " + thread.threadId());
        });

        running = true;
        thread.start();
    }

    public synchronized void stopThread()
    {
        running = false;
        MyLogger.logger.log(Level.FINE, "Running is false");
    }

    public synchronized boolean isRunning()
    {
        return running;
    }

    public synchronized boolean isActive()
    {
        return active;
    }

    public synchronized void setActive(boolean input)
    {
        active = input;
    }

    public synchronized Color getColor()
    {
        try
        {
            Color output = (Color)image.getFill();
            return output;
        }
        catch(ClassCastException e)
        {
            ErrorHandler.showError("Unable to read color data", "Unable to read color data in a cell");
            return new Color(0, 0, 0, 0);
        }
    }

    public synchronized void changeColor(Color color)
    {
        Platform.runLater(() ->
        {
            image.setFill(color);
            image.setStroke(color);
        });   
    }

    public synchronized Cell getSelf()
    {
        return this;
    }

    public Rectangle getImage()
    {
        return image;
    }

    @Override
    public void run()
    {
        while(isRunning())
        {
            try
            {
                Thread.sleep(random.nextLong(sleepTime) + (long)(sleepTime * 0.5));
            }
            catch(InterruptedException e)
            {
                ErrorHandler.showError("Thread Interruption error", "Thread nr " + thread.threadId() + " has been interrupted.");
            }

            if(isActive())
            {
                //MyLogger.logger.log(Level.FINE, "Start: " + thread.threadId());
                System.out.println("Start: " + thread.threadId());

                if(random.nextDouble(100.0 + Math.ulp(100.0d)) <= randomColorProbability)
                {
                    Color period = random.nextColor();
                    synchronized(locker)
                    {
                        changeColor(period);
                    }
                }
                else
                {
                    final double[] avgRed = {0};
                    final double[] avgGreen = {0};
                    final double[] avgBlue = {0};
                    final int[] count = {0};

                    synchronized(locker) //starts color change
                    {
                        synchronized(neighbors.get(0).getSelf())
                        { 
                            synchronized(neighbors.get(1).getSelf())
                            { 
                                synchronized(neighbors.get(2).getSelf())
                                {
                                    synchronized(neighbors.get(3).getSelf())
                                    { 
                                        for(Cell neighbor  : neighbors)
                                        {
                                            if(neighbor.isActive()) // to ensure synchronization
                                            {
                                                avgRed[0] += neighbor.getColor().getRed();
                                                avgGreen[0] += neighbor.getColor().getGreen();
                                                avgBlue[0] += neighbor.getColor().getBlue();
                                                ++count[0];
                                            }

                                            if(count[0] != 0)
                                            {
                                                changeColor(new Color(avgRed[0] / count[0], avgGreen[0] / count[0], avgBlue[0] / count[0], 1.0));
                                            }
                                            else
                                            {
                                                changeColor(random.nextColor());
                                            }
                                        }
                                    }
                                }
                            }
                        }  
                    }
                }
                //MyLogger.logger.log(Level.FINE, "End: " + thread.threadId());
                System.out.println("End: " + thread.threadId());
            }
        }
    } 
}
