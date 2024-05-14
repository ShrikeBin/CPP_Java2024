import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class of the Paint application.
 */
public class PaintApp extends Application 
{
    /**
     * The entry point of the application.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) 
    {
        MyLogger.loggerConfig();
        launch(args);
    }

    /**
     * Starts the JavaFX application.
     * @param stage The primary stage of the application.
     */
    @Override
    public void start(Stage stage) 
    {   
        // Define the available shapes
        String[] shapes = {"Ellipse", "Rectangle", "Triangle"};

        // Create a shape factory
        ShapeFactory factory = new ShapeFactory();
        factory.registerShape("Ellipse", () -> new MyEllipse());
        factory.registerShape("Rectangle", () -> new MyRectangle());
        factory.registerShape("Triangle", () -> new MyTriangle());

        // Initialize the PaintGUI with the specified stage, factory, and shapes
        new PaintGUI(stage, factory, shapes);
    }
}
