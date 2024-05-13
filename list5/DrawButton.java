import javafx.scene.control.ToggleButton;

public class DrawButton extends ToggleButton
{
    public DrawButton(PaintPane paintPane)
    {   
        super("Create / [Mark]");
        setOnAction(event -> 
        {
            paintPane.setCreateMode(isSelected());
            if (paintPane.getCreateMode()) 
            {
                setText("[Create] / Mark");
                paintPane.clearSelection();
            } 
            else 
            {
                setText("Create / [Mark]");
            }
        });
    }
}
