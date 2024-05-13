import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileMenu extends MenuBar
{
    private ShapeLoader shapeLoader;

    public FileMenu(PaintPane paintPane, Stage primaryStage, ShapeFactory factory) 
    {
        this.shapeLoader = ShapeLoader.getInstance();

        // Create File menu
        Menu fileMenu = new Menu("File");

        // Create Load option
        MenuItem loadMenuItem = new MenuItem("Load");

        loadMenuItem.setOnAction(e -> 
        {   
            shapeLoader.clearData();
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
                    for (ShapeData shape : shapeLoader.getShapes()) 
                    {
                        MyLogger.logger.log(Level.FINE,shape.getName() + " was loaded");
                        IMyShape object = factory.createShape(shape.getName(), shape.getPoints(), shape.getMyColor());
                        paintPane.getShapeList().add(object);
                        MyHandler.setBasicEvents(object, paintPane, paintPane.getRotateHandle());
                        paintPane.getChildren().add(object.getSelf());
                        object.rotateSelf(shape.getMyRotationAngle());
                        object.resizeSelf(shape.getMyScaleFactor());
                    }
                } 
                catch (IOException | ClassNotFoundException ex) 
                {
                    ErrorHandler.showError("Unable to load file", ex.getMessage());
                }
            }
        });

        // Create Save option
        MenuItem saveMenuItem = new MenuItem("Save");
        
        saveMenuItem.setOnAction(e -> 
        {
            shapeLoader.clearData();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save File");
            File file = fileChooser.showSaveDialog(primaryStage);

            if (file != null) 
            {
                try 
                {
                    for (IMyShape shape : paintPane.getShapeList()) 
                    {
                        shapeLoader.add(shape.getData());
                        MyLogger.logger.log(Level.FINE,shape.getData().getName() + " was saved");
                    }
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

