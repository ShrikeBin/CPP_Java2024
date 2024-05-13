import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;

public class ShapeLoader implements Serializable
{
    private static ShapeLoader instance;
    private ArrayList<ShapeData> shapes; //muszę tu zapisać dane czyli moje dwa punkty w których się znajdują moje kształty i ich obecny kolor żeby móc je odtworzyć

    private ShapeLoader()
    {
        shapes = new ArrayList<ShapeData>();
    }

    public static synchronized ShapeLoader getInstance() 
    {
        if (instance == null) 
        {
            instance = new ShapeLoader();
        }
        return instance;
    }

    public void add(ShapeData shape)
    {
        shapes.add(shape);
    }

    public ShapeData get(final int id)
    {
        if (id < 0 || id >= shapes.size())
        {
            throw new IllegalArgumentException("Out of bounds");
        }
        else
        {
            return shapes.get(id);
        }
    }

    public void setShapes(ArrayList<ShapeData> inputList) 
    {
        shapes = inputList;
    }

    public ArrayList<ShapeData> getShapes() 
    {
        return shapes;
    }

    public void save(File file) throws IOException 
    {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        try 
        {
            objectOutputStream.writeObject(instance);
        } 
        catch (IOException e)
        {
            MyLogger.logger.log(Level.FINE, "Unable to save file ", e);
        } 
        finally 
        {
            if (objectOutputStream != null) 
            {
                try 
                {
                    objectOutputStream.close();
                } 
                catch (IOException e) 
                {
                    MyLogger.logger.log(Level.FINE, "Error closing ObjectOutputStream", e);
                }
            }
            if (fileOutputStream != null) 
            {
                try 
                {
                    fileOutputStream.close();
                } 
                catch (IOException e) 
                {
                    MyLogger.logger.log(Level.FINE, "Error closing FileOutputStream", e);
                }
            }
        }
    }

    public void load(File file) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        try
        {
            instance = (ShapeLoader) objectInputStream.readObject();
        }
        catch (Exception e)
        {
            MyLogger.logger.log(Level.FINE, "Unable to load file ", e);
            instance = new ShapeLoader();
        }
        finally 
        {
            if (objectInputStream != null) 
            {
                try 
                {
                    objectInputStream.close();
                } 
                catch (IOException e) 
                {
                    MyLogger.logger.log(Level.FINE, "Error closing ObjectInputStream", e);
                }
            }
            if (fileInputStream != null) 
            {
                try 
                {
                    fileInputStream.close();
                } 
                catch (IOException e) 
                {
                    MyLogger.logger.log(Level.FINE, "Error closing FileInputStream", e);
                }
            }
        }
    }
}
