import javafx.scene.control.RadioButton;

/**
 * ResizeButton is a custom RadioButton for enabling resize functionality in the Paint application.
 */
public class ResizeButton extends RadioButton
{
    /**
     * Constructs a ResizeButton with the specified text and sets up the event handler.
     *
     * @param text The text to display on the button.
     * @param paneController The controller to manage the pane and shape behaviors.
     */
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
