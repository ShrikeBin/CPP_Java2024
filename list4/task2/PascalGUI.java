import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PascalGUI
{
    public PascalGUI(Stage stage)
    {
        TextField textField = new TextField();
        Label label = new Label();
        Button button = new GenerateButton("Execute", label, textField, stage);
        BorderPane root = new GUIPane(label, textField, button);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(300);
        stage.setMinHeight(250);
        stage.setTitle("PascalGUI");
        stage.show();
        MyLogger.logger.log(Level.INFO, "Scene has been inited");
    }
}
