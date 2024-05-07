import javafx.scene.control.ComboBox;

public class ShapeBox extends ComboBox<String>
{
    ShapeBox(String[] shapes)
    {
        super();
        getItems().addAll(shapes);
    }
}
