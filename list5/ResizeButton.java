import javafx.scene.control.RadioButton;

public class ResizeButton extends RadioButton
{
    public ResizeButton(String text, PaintPane pane) 
    {
        super(text);

        // Add event handler for selection change
        selectedProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (newValue) 
            {
                MyHandler.changeEventsResize(pane);
                pane.setRotateHandle(false);
            }
        });
    }
}
