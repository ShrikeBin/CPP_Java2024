
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;

public class PaintGUI 
{   
    PaintGUI(Stage stage, ShapeFactory factory, String[] shapes)
    {   
        ComboBox<String> shape = new ShapeBox(shapes);
        ColorPicker color = new ColorPicker();

        PaintPane shapePane = new PaintPane(factory, shape, color);
        
        Button paint = new ColorButton("Paint Shape", shapePane, color);
        ToggleButton draw = new DrawButton(shapePane);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton rotate = new RotateButton("Rotate", shapePane); //wypchnij do góry
        RadioButton resize = new ResizeButton("Resize", shapePane);

        rotate.setToggleGroup(toggleGroup);
        resize.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> 
        {
            if (newToggle == null) 
            {
                System.out.println("No button selected");
            } 
            else if (newToggle == resize) 
            {
                System.out.println("resize selected");
            } 
            else if (newToggle == rotate) 
            {
                System.out.println("rotate selected");
            }
        });

        BorderPane option = new OptionBox(shape, color, draw, paint, rotate, resize);
        BorderPane root = new BorderPane();
        root.setCenter(shapePane);
        root.setTop(option);
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("PaintGUI");
        stage.show();
    }
}
