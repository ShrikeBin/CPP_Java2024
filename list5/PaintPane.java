import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public class PaintPane extends Pane 
{
    private ArrayList<IMyShape> shapeList = new ArrayList<>();

    private ComboBox<String> shapeBox;
    private ColorPicker colorPicker;

    public PaintPane(ComboBox<String> shapeBox, ColorPicker colorPicker) 
    {
        super();

        this.shapeBox = shapeBox;
        this.colorPicker = colorPicker;
    }

    public ArrayList<IMyShape> getShapeList() 
    {
        return shapeList;
    }

    public ComboBox<String> getShapeBox() 
    {
        return shapeBox;
    }

    public ColorPicker getColorPicker() 
    {
        return colorPicker;
    }
}
