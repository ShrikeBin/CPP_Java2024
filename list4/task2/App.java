import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class App extends Application
{
    public static void main(String[] args)
    {
        //Thread.setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler ueh) to pełna nazwa
        //UncaughtExceptionHandler ma metodę void uncaughtException(Thread thread, Throwable throwable) którą tu nadpisuję
        //korzystając z rachunku lambda
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> 
        {
            if (throwable instanceof OutOfMemoryError) 
            {
                throwError("Out of Memory", "You ran out of memory...");
            } 
            else 
            {
                throwError("Error", "Other error ocured: " + throwable.getMessage());
            }
        });

        MyLogger.loggerConfig();
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {   
        new PascalGUI(stage);
    }

    private static void throwError(String title, String message) 
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
