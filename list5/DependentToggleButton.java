import java.util.HashMap;
import java.util.logging.Level;
import javafx.scene.control.ToggleButton;

public class DependentToggleButton 
{
    private HashMap<String, ToggleButton> buttonMap;

    public DependentToggleButton() 
    {
        buttonMap = new HashMap<>();
    }

    public void registerButton(String codename, ToggleButton button) 
    {
        buttonMap.put(codename, button);
        button.setOnAction(event -> 
        {
            button.fire(); //odpali wcześniejsze nadpisanie setOnAction
            uncheckOthers(codename);
        });
        
        MyLogger.logger.log(Level.FINER, "Registered new ToggleDependent Button");
    }

    public boolean isToggled(String codename)
    {
        return buttonMap.get(codename).isSelected();
    }

    private void uncheckOthers(String toggledCodename) 
    {
        for (String codename : buttonMap.keySet()) 
        {
            if (!codename.equals(toggledCodename)) 
            {
                buttonMap.get(codename).setSelected(false);
            }
        }
    }
}
