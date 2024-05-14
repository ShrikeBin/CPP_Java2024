import javafx.scene.control.RadioButton;

public class ResizeButton extends RadioButton
{
    public ResizeButton(String text, PaneController paneController) 
    {
        super(text);

        // Add event handler for selection change
        selectedProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (newValue) 
            {
                MyHandler.changeEventsResize(paneController);
                paneController.setRotate(false);
            }
        });
    }
}
