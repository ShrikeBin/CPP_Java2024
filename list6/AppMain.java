import java.util.logging.Level;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application
{
    public static void main(String[] args)
    {
        MyLogger.loggerConfig();
        MyLogger.logger.log(Level.INFO, "App is running");

        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        new AppGUI(stage);
    }
}
