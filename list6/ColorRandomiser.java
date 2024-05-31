import java.util.Random;
import java.lang.Math;
import javafx.scene.paint.Color;

public class ColorRandomiser extends Random
{
    public Color nextColor()
    {
        double bound = 1.0 + Math.ulp(1.0d);
        return new Color(nextDouble(bound), nextDouble(bound), nextDouble(bound), 1.0);
    }
}
