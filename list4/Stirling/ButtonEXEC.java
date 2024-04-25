import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;


public class ButtonEXEC extends Button
{
    public ButtonEXEC(String name, Sheet sheet, ComboBox<Integer> box, ComboBox<String> choice)
    {
        super(name);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                AppLogger.logger.log(Level.INFO, "Button clicked");

                if((box.getValue() == null)||(choice.getValue() == null))
                {
                    ErrorHandler.showError("Wrong value", "Please choose a value");
                    return;
                }

                    int n = box.getValue();
                    String type = choice.getValue();

                    if(type.equals("Stirling 1st type"))
                    {
                        SheetSet.setStirFirst(n, sheet);
                    }
                    else if(type.equals("Stirling 2nd type"))
                    {
                        SheetSet.setStirSecond(n, sheet);
                    }
            }
        });
    }
}
