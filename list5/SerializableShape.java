import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;

public class SerializableShape 
{
    private List<Point2D> basicPoints;
    private Paint MyColor;
    private double MyRotationAngle;
    private double MyScaleFactor = 1.0;

    public SerializableShape(List<Point2D> basicPoints, Paint Color, double RotationAngle, double ScaleFactor) 
    {
        this.basicPoints = basicPoints;
        this.MyColor = Color;
        this.MyRotationAngle = RotationAngle;
        this.MyScaleFactor = ScaleFactor;
    }

    public void setBasicPoints(List<Point2D> basicPoints) 
    {
        this.basicPoints = basicPoints;
    }

    public void setMyColor(Paint myColor) 
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

    public List<Point2D> getBasicPoints() 
    {
        return basicPoints;
    }

    public Paint getMyColor() 
    {
        return MyColor;
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
