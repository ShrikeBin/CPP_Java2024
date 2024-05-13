import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import java.util.Arrays;


public class ShapeData
{
    //bo Point2D się nie serializuje
    private double firstX;
    private double firstY;
    private double secondX;
    private double secondY;
    private Color MyColor;
    private double MyRotationAngle;
    private double MyScaleFactor = 1.0;
    private String codename;

    public ShapeData(String name) 
    {   
        this.codename = name;
        this.firstX = 0;
        this.firstY = 0;
        this.secondX = 0;
        this.secondY = 0;
        this.MyColor = null;
        this.MyRotationAngle = 0;
        this.MyScaleFactor = 1;
    }

    public void setName(String name)
    {
        codename = name;
    }

    public void setFirstPoint(Point2D generateStart) 
    {
        firstX = generateStart.getX();
        firstY = generateStart.getY();
    }

    public void setSecondPoint(Point2D generateEnd) 
    {
        secondX = generateEnd.getX();
        secondY = generateEnd.getY();
    }

    public void setMyColor(Color myColor) 
    {
        this.MyColor = myColor;
    }

    public void setMyRotationAngle(double RotationAngle) 
    {
        this.MyRotationAngle = RotationAngle;
    }

    public void setMyScaleFactor(double ScaleFactor) 
    {
        this.MyScaleFactor = ScaleFactor;
    }

    public void addDeltaX(double value)
    {
        addFirstX(value);
        addSecondX(value);
    }

    public void addDeltaY(double value)
    {
        addFirstY(value);
        addSecondY(value);
    }

    public void addFirstX(double value) 
    {
        this.firstX += value;
    }

    public void addFirstY(double value) 
    {
        this.firstY += value;
    }

    public void addSecondX(double value) 
    {
        this.secondX += value;
    }

    public void addSecondY(double value) 
    {
        this.secondY += value;
    }

    public List<Point2D> getPoints() 
    {
        return Arrays.asList(new Point2D(firstX, firstY), new Point2D(secondX, secondY));
    }

    public Color getMyColor() 
    {
        return MyColor;
    }

    public String getName()
    {
        return codename;
    }

    public double getMyRotationAngle() 
    {
        return MyRotationAngle;
    }

    public double getMyScaleFactor() 
    {
        return MyScaleFactor;
    }
}
