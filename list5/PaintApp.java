import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PaintApp extends Application {

    public Canvas canvas;
    public GraphicsContext gc;

    public List<Shape> shapes = new ArrayList<>();
    public Shape selectedShape;

    public double startX, startY; // For mouse click position
    public double offsetX, offsetY; // For shape movement
    public double dragStartX, dragStartY; // For shape resizing

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(600, 400);
        gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseClicked(this::handleMouseClicked);
        canvas.setOnMousePressed(this::handleMousePressed);
        canvas.setOnMouseDragged(this::handleMouseDragged);

        BorderPane root = new BorderPane(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Shape Editor");
        primaryStage.show();
    }

    private void handleMouseClicked(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if (selectedShape != null && selectedShape.containsPoint(x, y)) {
            return; // Clicking inside selected shape, no new shape added
        }

        shapes.add(new Rectangle(x, y, 50, 50)); // Add a rectangle by default
        redraw();
    }

    private void handleMousePressed(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        for (Shape shape : shapes) {
            if (shape.containsPoint(x, y)) {
                selectedShape = shape;
                offsetX = x - selectedShape.getX();
                offsetY = y - selectedShape.getY();

                dragStartX = x;
                dragStartY = y;

                redraw();
                return;
            }
        }

        selectedShape = null;
        redraw();
    }

    private void handleMouseDragged(MouseEvent event) {
        if (selectedShape != null) {
            double x = event.getX();
            double y = event.getY();

            if (event.isPrimaryButtonDown()) { // Move
                selectedShape.move(x - offsetX, y - offsetY);
            } else if (event.isSecondaryButtonDown()) { // Resize
                double diffX = x - dragStartX;
                double diffY = y - dragStartY;

                selectedShape.resize(diffX, diffY);
                dragStartX = x;
                dragStartY = y;
            }

            redraw();
        }
    }

    private void redraw() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shape shape : shapes) {
            shape.draw(gc);

            if (shape == selectedShape) {
                gc.setStroke(Color.BLUE);
                gc.setLineWidth(2);
                gc.strokeRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    abstract class Shape {
        protected double x, y;
        protected double width, height;

        Shape(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        abstract void draw(GraphicsContext gc);
        abstract boolean containsPoint(double x, double y);
        abstract void resize(double diffX, double diffY);

        double getX() {
            return x;
        }

        double getY() {
            return y;
        }

        double getWidth() {
            return width;
        }

        double getHeight() {
            return height;
        }

        void move(double newX, double newY) {
            this.x = newX;
            this.y = newY;
        }
    }

    class Rectangle extends Shape {
        Rectangle(double x, double y, double width, double height) {
            super(x, y, width, height);
        }

        @Override
        void draw(GraphicsContext gc) {
            gc.setFill(Color.RED);
            gc.fillRect(getX(), getY(), getWidth(), getHeight());
        }

        @Override
        boolean containsPoint(double x, double y) {
            return x >= getX() && x <= getX() + getWidth() &&
                    y >= getY() && y <= getY() + getHeight();
        }

        @Override
        void resize(double diffX, double diffY) {
            double newWidth = getWidth() + diffX;
            double newHeight = getHeight() + diffY;
            if (newWidth > 0 && newHeight > 0) {
                move(getX() - diffX / 2, getY() - diffY / 2);
                setWidth(newWidth);
                setHeight(newHeight);
            }
        }

        void setWidth(double width) {
            this.width = width;
        }

        void setHeight(double height) {
            this.height = height;
        }
    }
}
