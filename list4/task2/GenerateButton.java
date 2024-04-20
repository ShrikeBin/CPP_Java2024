import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenerateButton extends Button
{
    private int numClick;

    public int getNumClick()
    {
        return numClick;
    }

    public GenerateButton(String name, Label label, TextField textField, Stage stage)
    {
        super(name);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {
                try 
                {
                    //LOG
                    MyLogger.logger.log(Level.INFO, "Button clicked");
                    numClick++;

                    //Set
                    label.setText("");
                    int numRows = Integer.parseInt(textField.getText());

                    //Generate
                    PascalTriangle pascalTriangle = new PascalTriangle(numRows);
                    List<List<Long>> triangle = pascalTriangle.getTriangle();

                    //Build
                    int maxWidth = triangle.stream().mapToInt(row -> row.stream().mapToInt(num -> String.valueOf(num).length()).max().orElse(0)).max().orElse(1);
            
                    // Build triangle string with appropriate formatting
                    StringBuilder triangleStr = new StringBuilder();
                    for (List<Long> row : triangle) 
                    {
                        int padding = (maxWidth + 1) * (numRows - triangle.indexOf(row));
                        triangleStr.append(" ".repeat(padding / 2)); // Add leading spaces for alignment
                        
                        for (Long num : row) 
                        {
                            triangleStr.append(String.format("%-" + maxWidth + "s ", num)); // Add number with padding
                        }
                        triangleStr.append("\n");
                    }

                    //Display & LOG
                    label.setText(triangleStr.toString());  
                    MyLogger.logger.log(Level.INFO, "Generated a Triangle");

                } 
                catch (NumberFormatException ex) 
                {
                    ErrorHandler.showError("Please enter a valid integer", stage);
                    MyLogger.logger.log(Level.FINE, "Invalid input: " + textField.getText(), ex);
                } 
                catch (IllegalArgumentException ex) 
                {
                    ErrorHandler.showError("Invalid size for Pascal's Triangle\n" + ex.getMessage(), stage);
                    MyLogger.logger.log(Level.FINE, "Error occurred: " + ex.getMessage(), ex);
                }
            }
        });

    }
}
