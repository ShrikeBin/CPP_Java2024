import java.util.logging.Level;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AppGUI
{
    public AppGUI(Stage stage)
    {
        BorderPane root = new BorderPane();

        GridPane grid = new GridPane();
        ScrollPane scroll = new ScrollPane();

        TextField width = new TextField();
        width.setPromptText("width");
        TextField height = new TextField();
        height.setPromptText("height");
        TextField sleepTime = new TextField();
        sleepTime.setPromptText("sleepTime (ms)");
        TextField probability = new TextField();
        probability.setPromptText("probability (0 - 100)");

        GenerateButton generate = new GenerateButton(stage, scroll, width, height, sleepTime, probability);

        stage.setOnCloseRequest(event -> 
        {
            generate.getCellGrid().stopThreads(); //???
            MyLogger.logger.log(Level.INFO, "Stage closed");
        });
        

        grid.add(width, 0, 0);
        grid.add(height, 1, 0);
        grid.add(sleepTime, 2, 0);
        grid.add(probability, 3, 0);
        grid.add(generate, 4, 0);

        root.setTop(grid);
        root.setCenter(scroll);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Epilepsy Warning");
        stage.setWidth(600);
        stage.setHeight(500);
        stage.show();
    }
}
