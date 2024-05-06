import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class PaintGUI 
{
    PaintGUI(Stage stage)
    {   
        ComboBox<String> shape = new ShapeBox();
        ComboBox<String> color = new ColorBox();
        Button draw = new DrawButton();
        Button resize = new ResizeButton();
        Button rotate = new RotateButton();
        Button paint = new ColorButton();

        BorderPane root = new OptionBox(shape, color, draw, resize, paint, rotate);

        Pane shapePane = new Pane();
        VBox paneVBox = new VBox(shapePane);
        Scene scene = new Scene(new VBox(root, paneVBox));
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("PaintGUI");
        stage.show();
    }


    // public List<Shape> shapes = new ArrayList<>();
    // public Shape selectedShape;
    // public double startX, startY; // For mouse click position
    // public double offsetX, offsetY; // For shape movement
    // public double dragStartX, dragStartY; // For shape resizing
}
