import javafx.scene.paint.Color;

public interface CellStatus 
{
    abstract boolean getActive();
    abstract void setActive(boolean input);
    abstract Color getColor();
    abstract Cell getSelf();
}
