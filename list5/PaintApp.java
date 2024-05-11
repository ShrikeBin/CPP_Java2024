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
        String[] shapes = {"ellipse", "rectangle", "triangle"};

        ShapeFactory factory = new ShapeFactory();
        factory.registerShape("ellipse",() -> new MyEllipse());
        factory.registerShape("rectangle",() -> new MyRectangle());
        factory.registerShape("triangle", () -> new MyTriangle());

        new PaintGUI(stage, factory, shapes);
    }
}
