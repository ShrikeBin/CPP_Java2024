import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;


public class SimpleGUIPane extends BorderPane
{
    public SimpleGUIPane(TextField textField, Button button)
    {
        super(null, textField, null, null, null);

        textField.setPromptText("Enter number of rows");
    
        GridPane grid = new GridPane();
        grid.setHgap(0);

        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHgrow(Priority.NEVER); 
        leftColumn.setMinWidth(button.getWidth());

        ColumnConstraints rightColumn = new ColumnConstraints();
        rightColumn.setHgrow(Priority.ALWAYS);

        grid.add(textField, 1, 0);
        grid.add(button, 0, 0);

        grid.getColumnConstraints().addAll(leftColumn, rightColumn);

        this.setCenter(grid);

        this.setStyle("-fx-background-color: white;");

        this.setCache(true);

        this.setCursor(Cursor.DEFAULT);
    }
}