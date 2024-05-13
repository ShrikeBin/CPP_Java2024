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
        String[] shapes = {"Ellipse", "Rectangle", "Triangle"};

        ShapeFactory factory = new ShapeFactory();
        factory.registerShape("Ellipse",() -> new MyEllipse());
        factory.registerShape("Rectangle",() -> new MyRectangle());
        factory.registerShape("Triangle", () -> new MyTriangle());

        new PaintGUI(stage, factory, shapes);
    }
}
