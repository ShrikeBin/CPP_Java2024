import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;



public class PascalGUI
{
    public PascalGUI(Stage stage)
    {
        TextField textField = new TextField();
        Label label = new Label();
        Button button = new GenerateButton("Execute", label, textField);

        BorderPane border = new SimpleGUIPane(textField, button);
        ScrollPane scroll = new SimpleScrollPane(label);
        VBox root = new VBox(border, scroll);
        VBox.setVgrow(scroll, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(500);
        stage.setTitle("PascalGUI");
        stage.show();
        MyLogger.logger.log(Level.INFO, "Scene has been inited");
    }
}
