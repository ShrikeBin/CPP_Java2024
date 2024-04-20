import javafx.scene.layout.BorderPane;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.logging.*;

public class GUIBorderPane extends BorderPane
{
    public GUIBorderPane(Node label, Node textArea, Node button)
    {
        super(label, textArea, null, button, null);

        setPrefSize(400, 400);
        setCache(true);
        setCursor(Cursor.OPEN_HAND);
    }
}