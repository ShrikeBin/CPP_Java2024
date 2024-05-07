import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Test extends Application {

    private ArrayList<Polygon> triangles = new ArrayList<>();
    private Polygon selectedTriangle;
    private boolean createMode = false;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the triangles
        Pane root = new Pane();
        root.setPrefSize(400, 400);

        // Create a toggle button for switching between triangle creation and selection
        ToggleButton toggleButton = new ToggleButton("Create Mode");
        toggleButton.setOnAction(event -> {
            createMode = toggleButton.isSelected();
            if (createMode) {
                toggleButton.setText("Create Mode (Active)");
                // Clear selected triangle when switching to create mode
                clearSelection();
            } else {
                toggleButton.setText("Create Mode");
            }
        });

        // Set event handler for adding new triangles or marking triangles
        root.setOnMouseClicked(event -> {
            if (createMode) {
                // If in create mode, add a new triangle
                // Generate random color
                Color randomColor = Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));

                // Add a new triangle at the clicked position
                Polygon newTriangle = createTriangle(event.getX(), event.getY(), randomColor);
                root.getChildren().add(newTriangle);
                triangles.add(newTriangle);

                // Set event handlers for the new triangle
                setTriangleEventHandlers(newTriangle);
            } else {
                // If not in create mode, check if clicked on any triangle to mark it
                for (Polygon triangle : triangles) {
                    if (triangle.contains(event.getX(), event.getY())) {
                        selectTriangle(triangle);
                        break;
                    }
                }
            }
        });


        // Set event handler for moving and resizing the selected triangle
        for (Polygon triangle : triangles) {
            setTriangleEventHandlers(triangle);
        }

        // Create a BorderPane to hold the toggle button and the root pane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(toggleButton);
        borderPane.setCenter(root);

        // Create a Scene with the BorderPane
        Scene scene = new Scene(borderPane);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Toggle Button Example");
        primaryStage.show();
    }

    private Polygon createTriangle(double x, double y, Color color) {
        double[] points = 
        {
                x, y,
                x + 50, y + 50,
                x - 50, y + 50
        };
        Polygon triangle = new Polygon(points);
        triangle.setFill(color);
        triangle.setStroke(Color.BLACK);
        triangle.setStrokeWidth(2);
        return triangle;
    }

    private void selectTriangle(Polygon clickedTriangle) {
        clearSelection();
        selectedTriangle = clickedTriangle;
        selectedTriangle.setStroke(Color.GREEN);
    }

    private void clearSelection() {
        if (selectedTriangle != null) {
            selectedTriangle.setStroke(Color.BLACK);
            selectedTriangle = null;
        }
    }

    private void setTriangleEventHandlers(Polygon triangle) {
        triangle.setOnMousePressed(event -> {
            if (!createMode) {
                selectTriangle(triangle);
            }
        });

        triangle.setOnMouseDragged(event -> {
            if (!createMode && triangle.equals(selectedTriangle)) {
                // Move the selected triangle
                double deltaX = event.getX() - triangle.getTranslateX();
                double deltaY = event.getY() - triangle.getTranslateY();
                triangle.setTranslateX(event.getX());
                triangle.setTranslateY(event.getY());
            }
        });

        triangle.setOnScroll(event -> {
            if (!createMode && triangle.equals(selectedTriangle)) {
                // Resize the selected triangle
                double deltaScale = event.getDeltaY() / 100.0; // Get the deltaY of the scroll event
                resizeTriangle(triangle, deltaScale); // Resize the triangle
            }
        });
    }

    private void resizeTriangle(Polygon triangle, double deltaScale) {
        for (int i = 0; i < triangle.getPoints().size(); i++) {
            double newValue = triangle.getPoints().get(i) * (1.0 + deltaScale);
            triangle.getPoints().set(i, newValue);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
