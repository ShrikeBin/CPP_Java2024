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
        new PaintGUI(stage);
    }
}
