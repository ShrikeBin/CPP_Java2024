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


public class SimpleGUIPane extends BorderPane
{
    public SimpleGUIPane(TextField textField, Button button)
    {
        super(null, textField, null, null, null);

        textField.setPromptText("Enter number of rows");
    
        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(5);

        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHgrow(Priority.NEVER); 
        leftColumn.setMinWidth(button.getWidth());

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHgrow(Priority.ALWAYS);
        rightColumn.setMinWidth(150);

        grid.add(textField, 1, 0);
        grid.add(button, 0, 0);

        grid.getColumnConstraints().addAll(leftColumn, rightColumn);

        this.setCenter(grid);

        this.setStyle("-fx-background-color: white;");

        this.setCache(true);

        this.setCursor(Cursor.DEFAULT);
    }
}