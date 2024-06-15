public class Node<T>
{
    private T stem;
    private Node<T> left;
    private Node<T> right;

    Node(T input)
    {
        stem = input;
        left = right = null;
    }

    public void setLeft(Node<T> left) 
    {
        this.left = left;
    }

    public void setRight(Node<T> right) 
    {
        this.right = right;
    }

    public Node<T> getLeft() 
    {
        return left;
    }

    public Node<T> getRight() 
    {
        return right;
    }

    public T getStem() 
    {
        return stem;
    }

    public void setStem(T input)
    {
        stem = input;
    }
}
