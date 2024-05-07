
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class PaintGUI 
{   
    PaintGUI(Stage stage, ShapeFactory factory, String[] shapes)
    {   
        PaintPane shapePane = new PaintPane(factory);
        ComboBox<String> shape = new ShapeBox(shapes);
        ComboBox<String> color = new ColorBox();
        Button draw = new DrawButton();
        Button resize = new ResizeButton();
        Button rotate = new RotateButton();
        Button paint = new ColorButton();

        BorderPane root = new OptionBox(shape, color, draw, resize, paint, rotate);
        
        VBox paneVBox = new VBox(shapePane);
        Scene scene = new Scene(new VBox(root, paneVBox));
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("PaintGUI");
        stage.show();
    }
}
