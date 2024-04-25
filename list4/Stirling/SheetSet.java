import java.util.logging.Level;

public class SheetSet 
{
    private SheetSet()
    {
        throw new InstantiationError("SheetSet is static class");
    }

    public static void setStirFirst(int n, Sheet sheet) 
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0, got " + n);
        }

        Triangle triangle = new Triangle(n,"s1");
        sheet.Clear();

        for(int y = 0; y <= n; ++y)
        {
            for(int x = 0; x <= y; ++x)
            {
                sheet.Get(y, n - y + 2*x).setText(triangle.GetTriangle().get(y).get(x).toString());
            }
        }
        AppLogger.logger.log(Level.INFO, "Triangle generated");
    }
    public static void setStirSecond(int n, Sheet sheet) 
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0, got " + n);
        }
        
        Triangle triangle = new Triangle(n,"s2");
        sheet.Clear();

        for(int y = 0; y <= n; ++y)
        {
            for(int x = 0; x <= y; ++x)
            {
                sheet.Get(y, n - y + 2*x).setText(triangle.GetTriangle().get(y).get(x).toString());
            }
        }
        AppLogger.logger.log(Level.INFO, "Triangle generated");
    }
}   
