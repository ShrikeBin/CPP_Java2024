
import javafx.scene.control.ToggleButton;

public class DrawButton extends ToggleButton
{
    public DrawButton(PaintPane paintPane)
    {   
        super("Mark Mode");
        setOnAction(event -> 
        {
            paintPane.setCreateMode(isSelected());
            if (paintPane.getCreateMode()) 
            {
                setText("Create Mode (Active)");
                paintPane.clearSelection();
            } 
            else 
            {
                setText("Mark Mode");
            }
        });
    }
}
