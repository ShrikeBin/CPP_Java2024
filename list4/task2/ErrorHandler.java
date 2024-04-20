import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ErrorHandler 
{
    public static void showError(String title, String message) 
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
