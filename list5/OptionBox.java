import javafx.geometry.Pos;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class OptionBox extends BorderPane
{
    OptionBox(ComboBox<String> shapes, ColorPicker color, ButtonBase createMode, ButtonBase paint, ButtonBase rotate, ButtonBase resize)
    {
        super();

        VBox comboVBox = new VBox(shapes, color);
        comboVBox.setSpacing(10);

        VBox buttons1 = new VBox(createMode, paint);
        buttons1.setSpacing(10);

        VBox buttons2 = new VBox(rotate, resize);
        buttons2.setSpacing(10);

        comboVBox.setAlignment(Pos.TOP_CENTER);
        buttons1.setAlignment(Pos.TOP_CENTER);
        buttons2.setAlignment(Pos.TOP_CENTER);

        setLeft(comboVBox);
        setCenter(buttons1);
        setRight(buttons2);
    }
}
