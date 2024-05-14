import javafx.scene.control.RadioButton;

public class RotateButton extends RadioButton
{
    public RotateButton(String text, PaneController paneController) 
    {
        super(text);

        // Add event handler for selection change
        selectedProperty().addListener((observable, oldValue, newValue) -> 
        {
            if (newValue) 
            {
                MyHandler.changeEventsRotate(paneController);
                paneController.setRotate(true);
            }
        });
    }
}
