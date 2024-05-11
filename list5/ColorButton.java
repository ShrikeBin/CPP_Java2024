import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class ColorButton extends Button
{
    public ColorButton(String title, PaintPane paintPane, ColorPicker color) 
    {
        super(title);

        // Set initial color to black
        color.setValue(Color.BLACK);

        setOnAction(event -> 
        {
            if(paintPane.getSelectedShape() != null)
            {
                paintPane.getSelectedShape().paintSelf(color.getValue());
            }
        });
    }
}
