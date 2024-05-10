
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;

public class PaintGUI 
{   
    PaintGUI(Stage stage, ShapeFactory factory, String[] shapes)
    {   
        ComboBox<String> shape = new ShapeBox(shapes);
        ColorPicker color = new ColorPicker();
        ToggleButton draw = new DrawButton();
        Button paint = new ColorButton();

        ToggleButton rotate = new RotateButton();
        ToggleButton resize = new ResizeButton();

        DependentToggleButton rotateResize = new DependentToggleButton();
        rotateResize.registerButton("resize", resize);
        rotateResize.registerButton("rotate", rotate);

        PaintPane shapePane = new PaintPane(factory, shape, color, rotateResize);
        BorderPane root = new OptionBox(shape, color, draw, paint, rotate, resize);
        
        VBox paneVBox = new VBox(shapePane);
        Scene scene = new Scene(new VBox(root, paneVBox));
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("PaintGUI");
        stage.show();
    }
}
