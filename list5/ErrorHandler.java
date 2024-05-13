import java.util.logging.Level;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorHandler 
{
    private ErrorHandler()
    {
        throw new InstantiationError("ErrorHandler is static class");
    }

    public static void showError(String title, String message) 
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        MyLogger.logger.log(Level.FINE, title + " " + message);
        alert.showAndWait();
    }
}
