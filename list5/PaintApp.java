import javafx.application.Application;
import javafx.stage.Stage;
import java.util.function.Supplier;


public class PaintApp extends Application 
{
    public static void main(String[] args) 
    {
        MyLogger.loggerConfig();
        launch(args);
    }

    @Override
    public void start(Stage stage) 
    {   
        String[] shapes = {"circle", "rectangle", "triangle"};

        ShapeFactory factory = new ShapeFactory();
        factory.registerShape("circle", new Supplier<MyShape>()
        {
            @Override 
            public MyShape get()
            { 
                return new MyCircle(0, 0);
            }
        });
        factory.registerShape("rectangle", new Supplier<MyShape>()
        {
            @Override 
            public MyShape get()
            { 
                return new MyRectangle(0,0);
            }
        });
        factory.registerShape("triangle", new Supplier<MyShape>()
        {
            @Override 
            public MyShape get()
            { 
                return new MyTriangle(0,0);
            }
        });

        new PaintGUI(stage, factory, shapes);
    }
}
