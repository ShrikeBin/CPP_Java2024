import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.logging.*;

public class GUI
{
    private Label lbl;
    public GUI(Stage stage)
    {
        TextArea txtArea = new TextArea();
        lbl = new Label();
        Button btn = new GUIButton("Wykonaj", lbl, txtArea);
        BorderPane root = new GUIBorderPane(lbl, txtArea, btn);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BorderPane");
        stage.show();
        MyLogger.logger.log(Level.INFO, "Scene has been inited");
    }
}
