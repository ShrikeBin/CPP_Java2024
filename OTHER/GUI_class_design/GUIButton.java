import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.logging.*;


public class GUIButton extends Button
{
    private int numClick;

    public int getNumClick()
    {
        return numClick;
    }

    public GUIButton(String name, Label label, TextArea textArea)
    {
        super(name);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                MyLogger.logger.log(Level.INFO, "Button");
                label.setText(textArea.getText());
                numClick++;
                textArea.setText(Integer.toString(numClick));
            }
        });

    }
}
