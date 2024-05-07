import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class TestCircle extends Application 
{

    private ArrayList<Circle> circles = new ArrayList<>();
    private Circle selectedCircle;
    private boolean createMode = false;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the circles
        Pane root = new Pane();
        root.setPrefSize(400, 400);

        // Create a toggle button for switching between circle creation and selection
        ToggleButton toggleButton = new ToggleButton("Create Mode");
        toggleButton.setOnAction(event -> {
            createMode = toggleButton.isSelected();
            if (createMode) {
                toggleButton.setText("Create Mode (Active)");
                // Clear selected circle when switching to create mode
                clearSelection();
            } else {
                toggleButton.setText("Create Mode");
            }
        });

        // Set event handler for adding new circles or marking circles
        root.setOnMouseClicked(event -> {
            if (createMode) {
                // If in create mode, add a new circle
                // Generate random color
                Color randomColor = Color.rgb(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));

                // Add a new circle at the clicked position
                Circle newCircle = createCircle(event.getX(), event.getY(), 20, randomColor);
                root.getChildren().add(newCircle);
                circles.add(newCircle);

                // Set event handlers for the new circle
                setCircleEventHandlers(newCircle);
            } else {
                // If not in create mode, check if clicked on any circle to mark it
                for (Circle circle : circles) {
                    if (circle.contains(event.getX(), event.getY())) {
                        selectCircle(circle);
                        break;
                    }
                }
            }
        });


        // Set event handler for moving and resizing the selected circle
        for (Circle circle : circles) {
            setCircleEventHandlers(circle);
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

    private Circle createCircle(double centerX, double centerY, double radius, Color color) {
        Circle circle = new Circle(centerX, centerY, radius, color);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        return circle;
    }

    private void selectCircle(Circle clickedCircle) {
        clearSelection();
        selectedCircle = clickedCircle;
        selectedCircle.setStroke(Color.GREEN);
    }

    private void clearSelection() {
        if (selectedCircle != null) {
            selectedCircle.setStroke(Color.BLACK);
            selectedCircle = null;
        }
    }

    private void setCircleEventHandlers(Circle circle) {
        circle.setOnMousePressed(event -> {
            if (!createMode) {
                selectCircle(circle);
            }
        });
    
        circle.setOnMouseDragged(event -> {
            if (!createMode && circle.equals(selectedCircle)) {
                // Move the selected circle
                double newX = event.getX();
                double newY = event.getY();
                circle.setCenterX(newX);
                circle.setCenterY(newY);
            }
        });
    
        circle.setOnScroll(event -> {
            if (!createMode && circle.equals(selectedCircle)) {
                // Resize the selected circle
                double deltaScale = event.getDeltaY() / 100.0; // Get the deltaY of the scroll event
                resizeCircle(circle, deltaScale); // Resize the circle
            }
        });
    }
    

    private void resizeCircle(Circle circle, double deltaScale) {
        double newRadius = circle.getRadius() * (1.0 + deltaScale);
        if (newRadius > 5) { // Ensure minimum radius
            circle.setRadius(newRadius);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
