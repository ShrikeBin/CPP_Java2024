import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;

public class AppGUI
{
    public AppGUI(Stage stage)
    {
        Sheet sheet = new Sheet(68, 68);

        ComboBox<Integer> box = new ComboBox<Integer>();
        box.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        box.setPromptText("Choose number of row");
        box.setPrefWidth(ComboBox.USE_COMPUTED_SIZE);
        box.setMaxWidth(Double.MAX_VALUE);

        ComboBox<String> choice= new ComboBox<String>();
        choice.getItems().addAll("Stirling 1st type","Stirling 2nd type", "Pascal Triangle");
        choice.setPromptText("Choose type");
        choice.setPrefWidth(ComboBox.USE_COMPUTED_SIZE);
        choice.setMaxWidth(Double.MAX_VALUE);

        Button button = new ButtonEXEC("Render", sheet, box, choice);
        button.setPrefWidth(Button.USE_COMPUTED_SIZE);
        button.setMaxWidth(Double.MAX_VALUE);

        DropdownPane dropdown = new DropdownPane(box, button, choice);

        ScrollPane scroll = new ScrollPane(sheet);

        VBox root = new VBox();
        root.getChildren().add(dropdown);
        root.getChildren().add(scroll);

        VBox.setVgrow(scroll, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(500);
        stage.setWidth(600);
        stage.setHeight(500);
        stage.setTitle("Stirling's Triangle");
        stage.show();
        AppLogger.logger.log(Level.INFO, "Scene has been inited");
    }
}
