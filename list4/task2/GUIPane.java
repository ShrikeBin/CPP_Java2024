import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.logging.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUIPane extends BorderPane
{
    public GUIPane(Label label, TextField textField, Button button)
    {
        super(label, textField, null, null, null);

        label.setFont(Font.font("Arial", 14));
        textField.setPromptText("Enter number of rows");
    
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHgrow(Priority.ALWAYS); 
        leftColumn.setMinWidth(150); 

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHgrow(Priority.NEVER);
        rightColumn.setMinWidth(button.getWidth());

        grid.add(textField, 0, 0);
        grid.add(button, 1, 0);
        grid.add(label, 0, 1, 2, 1);

        grid.getColumnConstraints().addAll(leftColumn, rightColumn);

        this.setCenter(grid);

        this.setStyle("-fx-background-color: WHITE;");

        this.setCache(true);

        this.setCursor(Cursor.DEFAULT);
    }
}