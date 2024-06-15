import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> 
{
    private Node<T> root;

    BinaryTree(Node<T> root)
    {
        this.root = root;
    }

    public Node<T> getRoot() 
    {
        return root;
    }

    public void addNode(T parentData) 
    {
        Node<T> input = new Node<T>(parentData);

        if (root == null)
        {
            this.root = input;
        }
        else
        {
            Queue<Node<T>> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) 
            {
                Node<T> tempNode = queue.poll();

                if(tempNode.getLeft() == null)
                {
                    tempNode.setLeft(new Node<T>(parentData));
                    break;
                }
                else if (tempNode.getRight() == null)
                {
                    tempNode.setRight(new Node<T>(parentData));
                    break;
                }
                else
                {
                    queue.offer(tempNode.getLeft());
                    queue.offer(tempNode.getRight());
                }
            }
        }
    }

    public void deleteNode(T keyData) //deletes the Node of a given key
    {
        if(root == null)
        {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        Node<T> tempNode = null;
        Node<T> keyNode = null;

        while (!queue.isEmpty()) 
        {
            tempNode = queue.poll();

            if (tempNode.getStem() == keyData)
            {
                keyNode = tempNode;
            }
            if (tempNode.getLeft() != null)
            {
                queue.offer(tempNode.getLeft());
            }
            if (tempNode.getRight() != null)
            {
                queue.offer(tempNode.getRight());
            }

            if (keyNode != null) 
            {
                T x = tempNode.getStem();
                keyNode.setStem(x);
                deleteDeepest(tempNode);
            }
        }
    }

    private void deleteDeepest(Node<T> keyNode)  //deletes the deepest given Node
    {
        if(root == null)
        {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        Node<T> tempNode = null;

        while (!queue.isEmpty()) 
        {
            tempNode = queue.poll();
            if (tempNode == keyNode) 
            {
                tempNode = null;
                keyNode = null;
                return;
            }
            if (tempNode.getRight() != null) 
            {
                if (tempNode.getRight() == keyNode) 
                {
                    tempNode.setRight(null);
                    keyNode = null;
                    return;
                }
                else
                {
                    queue.offer(tempNode.getRight());
                }
            }
            if (tempNode.getLeft() != null) 
            {
                if (tempNode.getLeft() == keyNode) 
                {
                    tempNode.setLeft(null);
                    keyNode = null;
                    return;
                } 
                else
                {
                    queue.offer(tempNode.getLeft());
                }
            }
        }
    }

}
