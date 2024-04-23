import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;


public class ButtonPascal extends Button
{
    public ButtonPascal(String name, Sheet sheet, ComboBox<Integer> box)
    {
        super(name);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                AppLogger.logger.log(Level.INFO, "Button clicked");

                if(box.getValue() == null)
                {
                    ErrorHandler.showError("Wrong value", "Please choose a value");
                    return;
                }
                else if (box.getValue() > 5)
                {
                    ErrorHandler.showError("Note", "THIS WILL TAKE SOME TIME -> CPP APP READING IS SEVERELY UNOPTIMIZED");
                }

                int n = box.getValue();
                PascalsTriangle triangle = new PascalsTriangle(n);
                sheet.Clear();
                for(int y = 0; y <= n; ++y)
                {
                    for(int x = 0; x <= y; ++x)
                    {
                        sheet.Get(y, n - y + 2*x).setText(triangle.GetTriangle().get(y).get(x).toString());
                    }
                }

                AppLogger.logger.log(Level.INFO, "Triangle generated");
            }
        });
    }
}
