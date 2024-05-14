import javafx.scene.control.ToggleButton;

public class DrawButton extends ToggleButton
{
    public DrawButton(PaneController paneController)
    {   
        super("Create / [Mark]");
        setOnAction(event -> 
        {
            paneController.setCreateMode(isSelected());
            if (paneController.isCreateMode()) 
            {
                setText("[Create] / Mark");
                paneController.clearSelection();
            } 
            else 
            {
                setText("Create / [Mark]");
            }
        });
    }
}
