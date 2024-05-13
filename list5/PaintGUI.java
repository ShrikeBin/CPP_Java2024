import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;


public class PaintGUI 
{   
    PaintGUI(Stage stage, ShapeFactory factory, String[] shapes) 
    {   
        // Create shape selection ComboBox
        ComboBox<String> shape = new ShapeBox(shapes);
        shape.setValue(shapes[0]);
    
        // Create color picker for shape color
        ColorPicker color = new ColorPicker();
    
        // Create PaintPane for drawing shapes
        PaintPane shapePane = new PaintPane(factory, shape, color);
    
        // Create buttons and toggle buttons for actions
        Button paint = new ColorButton("Change shape color", shapePane, color);
        ToggleButton draw = new DrawButton(shapePane);
        RadioButton rotate = new RotateButton("Rotate", shapePane);
        RadioButton resize = new ResizeButton("Resize", shapePane);
        rotate.setSelected(true); // Select rotate by default
    
        // Group rotate and resize radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        rotate.setToggleGroup(toggleGroup);
        resize.setToggleGroup(toggleGroup);
    
        // Create menu bar for file operations
        MenuBar fileMenuBar = new FileMenu(shapePane, stage, factory);
        Button deleteButton = new DeleteButton("Delete", shapePane);
    
        // Create option box containing shape selection, color picker, buttons, and menu bar
        BorderPane option = new OptionBox(shape, color, draw, paint, rotate, resize, fileMenuBar, deleteButton);
        option.setStyle("-fx-background-color: #a1a1a1;");
    
        // Create root BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(shapePane);
    
        // Create panel BorderPane for option box and logo
        BorderPane panel = new BorderPane();
    
        // Load and display logo image
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/LOGO.png")));
        imageView.setPreserveRatio(true);
        StackPane imagePane = new StackPane(imageView);
        imagePane.setAlignment(Pos.TOP_LEFT); // Align logo to top-left
        BorderPane.setMargin(imagePane, new Insets(3, 0, 10, 50)); // Add margin around the logo
    
        // Add logo to the center of the panel
        BorderPane.setAlignment(imagePane, Pos.TOP_LEFT);
        panel.setCenter(imagePane);
    
        // Align option box to the left side of the panel
        BorderPane.setAlignment(option, Pos.TOP_LEFT);
        panel.setLeft(option);
    
        panel.setStyle("-fx-background-color: #a1a1a1;");
    
        // Set panel as the top element of the root BorderPane
        root.setTop(panel);
              
        // Set scene and stage properties
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("PaintGUI");
        stage.show();
    }
}
