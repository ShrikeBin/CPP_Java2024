import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.logging.Logger;


public class App extends Application
{
    public static void main(String[] args)
    {
        MyLogger.loggerConfig();
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        new PascalGUI(stage);
    }
}
