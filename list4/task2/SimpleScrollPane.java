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
import javafx.scene.control.ScrollPane;

public class SimpleScrollPane extends ScrollPane
{
    public SimpleScrollPane(Label label)
    {
        super();

        label.setFont(Font.font("Arial", 14));

        setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 3px;");
        setContent(label);
    }

}
