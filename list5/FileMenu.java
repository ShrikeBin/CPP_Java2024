import java.io.File;
import java.io.IOException;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileMenu extends MenuBar
{
    private ShapeLoader shapeLoader;

    public FileMenu(PaintPane paintPane, Stage primaryStage) 
    {
        this.shapeLoader = ShapeLoader.getInstance();

        // Create File menu
        Menu fileMenu = new Menu("File");

        // Create Load option
        MenuItem loadMenuItem = new MenuItem("Load");

        loadMenuItem.setOnAction(e -> 
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(primaryStage);

            if (file != null) 
            {
                try 
                {
                    shapeLoader.load(file);
                    paintPane.getShapeList().clear();
                    paintPane.getChildren().clear();
                    paintPane.getShapeList().addAll(shapeLoader.getShapes());

                    for (IMyShape shape : shapeLoader.getShapes()) 
                    {
                        MyHandler.setBasicEvents(shape, paintPane, paintPane.getRotateHandle());
                        paintPane.getChildren().add(shape.getSelf());
                    }
                } 
                catch (IOException ex) 
                {
                    ErrorHandler.showError("Unable to load file", ex.getMessage());
                }
            }
        });

        // Create Save option
        MenuItem saveMenuItem = new MenuItem("Save");
        
        saveMenuItem.setOnAction(e -> 
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            File file = fileChooser.showSaveDialog(primaryStage);

            if (file != null) 
            {
                try 
                {
                    shapeLoader.setShapes(paintPane.getShapeList());
                    shapeLoader.save(file);
                } 
                catch (IOException ex) 
                {
                    ErrorHandler.showError("Unable to save file", ex.getMessage());
                }
            }
        });

        // Add options to File menu
        fileMenu.getItems().addAll(loadMenuItem, saveMenuItem);

        // Add File menu to MenuBar
        this.getMenus().add(fileMenu);
    }
}

