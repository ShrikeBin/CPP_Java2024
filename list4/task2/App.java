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
        MyLogger.loggerConfig();
        
        //Thread.setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler ueh) to pełna nazwa
        //UncaughtExceptionHandler ma metodę void uncaughtException(Thread thread, Throwable throwable) którą tu nadpisuję
        //korzystając z rachunku lambda
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> 
        {
            if (throwable instanceof OutOfMemoryError) 
            {
                ErrorHandler.showError("Out of Memory", "You ran out of memory...");
                MyLogger.logger.log(Level.SEVERE, "Out of memory", throwable);
            } 
            else 
            {
                ErrorHandler.showError("Error", "Other error ocured: " + throwable.getMessage());
                MyLogger.logger.log(Level.SEVERE, "Other error", throwable);
            }
        });

        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {   
        new PascalGUI(stage);
    }
}
