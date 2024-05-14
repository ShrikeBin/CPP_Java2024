import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorButton extends Button
{
    public ColorButton(String title, PaneController paneController, ColorPicker color) 
    {
        super(title);

        // Set initial color to black
        color.setValue(Color.BLACK);

        setOnAction(event -> 
        {
            if(paneController.getSelectedShape() != null)
            {
                paneController.getSelectedShape().paintSelf(color.getValue());
            }
        });
    }
}
