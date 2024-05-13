import javafx.scene.control.Button;
import java.util.Iterator;

public class DeleteButton extends Button
{
    public DeleteButton(PaintPane paintPane)
    {   
        super("Delete");

        setOnAction(event -> 
        {
            if(paintPane.getSelectedShape() != null)
            {
                paintPane.getChildren().remove(paintPane.getSelectedShape().getSelf());
                
                Iterator<IMyShape> iterator = paintPane.getShapeList().iterator(); //poczytaj czemu tak
                while (iterator.hasNext()) 
                {
                    IMyShape shape = iterator.next();

                    if (shape.equals(paintPane.getSelectedShape())) 
                    {
                        iterator.remove();
                        break;
                    }
                }

                paintPane.setSelectedShape(null);
            }
        });
    }
}
