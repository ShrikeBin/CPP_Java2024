import javafx.scene.control.ComboBox;

public class ColorBox extends ComboBox<String>
{
    ColorBox()
    {
        super();
        getItems().addAll("blue", "red", "black");
    }
}
