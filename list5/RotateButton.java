
import javafx.scene.control.RadioButton;

public class RotateButton extends RadioButton
{
    public RotateButton(String text, PaintPane pane) 
    {
        super(text);

        // Add event handler for selection change
        selectedProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (newValue) 
            {
                MyHandler.changeEventsRotate(pane);
                pane.setRotateHandle(true);
            }
        });
    }
}
