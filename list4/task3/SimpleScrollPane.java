import javafx.scene.control.Label;
import javafx.scene.text.Font;
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
