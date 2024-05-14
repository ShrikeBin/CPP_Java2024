import javafx.scene.control.Button;
import java.util.Iterator;

public class DeleteButton extends Button
{
    public DeleteButton(String title, PaneController paneController)
    {   
        super(title);

        setOnAction(event -> 
        {
            if(paneController.getSelectedShape() != null)
            {
                paneController.getPaintPane().getChildren().remove(paneController.getSelectedShape().getSelf());
                
                Iterator<IMyShape> iterator = paneController.getPaintPane().getShapeList().iterator(); //poczytaj czemu tak
                while (iterator.hasNext()) 
                {
                    IMyShape shape = iterator.next();

                    if (shape.equals(paneController.getSelectedShape())) 
                    {
                        iterator.remove();
                        break;
                    }
                }

                paneController.setSelectedShape(null);
            }
        });
    }
}
