import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;


public class GenerateButton extends Button
{
    private int numClick;

    public int getNumClick()
    {
        return numClick;
    }

    public GenerateButton(String name, Label label, TextField textField)
    {
        super(name);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                try 
                {
                    MyLogger.logger.log(Level.INFO, "Button clicked");
                    numClick++;

                    label.setText("");
                    int numRows = Integer.parseInt(textField.getText());

                    if(numRows > 10)
                    {
                        ErrorHandler.showError("Note", "This will take a while to load");
                    }
                    else if(numRows > 30)
                    {
                        throw new IllegalArgumentException("I do not recoment using bigger numbers - cpp program reading is unoptimized");
                    }

                    PascalTriangle pascalTriangle = new PascalTriangle(numRows);
                    List<List<BigInteger>> triangle = pascalTriangle.getTriangle();

                    //  Build 
                    //  streamuje triangle do intów, 
                    //  tak że cały trojkat do rowów kazdy row do elementu 
                    //  a kazdy element do stringa i 
                    //  bierze rozmiar tego stringa i max() to największy z nich, jeśli cały triangle jest pusty to orElse() daje 1
                    int maxWidth = triangle.stream().mapToInt(row -> row.stream().mapToInt(num -> String.valueOf(num).length()).max().orElse(0)).max().orElse(1);
            
                    //Format
                    StringBuilder triangleStr = new StringBuilder();

                    for (List<BigInteger> row : triangle) 
                    {
                        triangleStr.setLength(0);

                        int padding = (maxWidth + 3) * (numRows - triangle.indexOf(row));

                        // dodaje padding/2 * spacja na początku lini
                        triangleStr.append(" ".repeat(padding / 2));
                        
                        for (BigInteger num : row) 
                        {
                            // bierze maxWidth czyli nasza największa liczba
                            // i bierze nasz (n k), i wstawia go jako stringa
                            // o długości maxwidth sformatowanego tak, że
                            // jest przy lewej a reszta to spacje aż do długości maxWidth (no bo dodaje maxidth z prawej)
                            // String.format(%Ns) N- int dający minimalną długość stringa (dla mnie info)
                            triangleStr.append(String.format("%" + maxWidth + "s  ", num));
                        }
                        triangleStr.append("\n");
                        
                        label.setText(label.getText() + triangleStr.toString());
                    }

                    MyLogger.logger.log(Level.INFO, "Generated a Triangle");

                } 
                catch (NumberFormatException ex) 
                {
                    ErrorHandler.showError("Error", "Please enter a valid integer");
                    MyLogger.logger.log(Level.FINE, "Invalid input: " + textField.getText(), ex);
                } 
                catch (IllegalArgumentException ex) 
                {
                    ErrorHandler.showError("Error", "Invalid size for Pascal's Triangle\n" + ex.getMessage());
                    MyLogger.logger.log(Level.FINE, "Error occurred: " + ex.getMessage(), ex);
                }
            }
        });

    }
}
