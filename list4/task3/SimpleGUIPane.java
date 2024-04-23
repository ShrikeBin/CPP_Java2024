import javafx.scene.Cursor;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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