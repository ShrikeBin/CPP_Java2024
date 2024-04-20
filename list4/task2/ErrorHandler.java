import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ErrorHandler 
{

    public static void showError(String message, Stage stage) 
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
