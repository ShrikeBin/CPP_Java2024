import javafx.application.Application;
import javafx.stage.Stage;


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
        factory.registerShape("circle",() -> new MyCircle(null));
        factory.registerShape("rectangle",() -> new MyRectangle(null));
        factory.registerShape("triangle", () -> new MyTriangle(null));

        new PaintGUI(stage, factory, shapes);
    }
}
