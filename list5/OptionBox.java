import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class OptionBox extends BorderPane
{
    OptionBox(ComboBox<String> combo1, ComboBox<String> combo2, Button button1, Button button2, Button button3, Button button4)
    {
        super();

        VBox comboVBox = new VBox(combo1, combo2);
        comboVBox.setSpacing(10);

        VBox buttons1 = new VBox(button1, button2);
        buttons1.setSpacing(10);

        VBox buttons2 = new VBox(button3, button4);
        buttons2.setSpacing(10);

        comboVBox.setAlignment(Pos.TOP_CENTER);
        buttons1.setAlignment(Pos.TOP_CENTER);
        buttons2.setAlignment(Pos.TOP_CENTER);

        setLeft(comboVBox);
        setCenter(buttons1);
        setRight(buttons2);
    }
}
