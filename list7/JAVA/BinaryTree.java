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

    public void deleteNode(T keyData) //deletes the Nodes of a given key
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
        }
        
        if (keyNode != null) 
        {
            T deepestNodeData = tempNode.getStem();
            keyNode.setStem(deepestNodeData);
            deleteDeepest(tempNode);
        }
    
    }

    private void deleteDeepest(Node<T> keyNode)  //deletes the deepest given Node (right-most, bottom-most) (checks for LeftChild, Right Child)
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

    //(Root - Left - Right)
    public void printTreeOrder() 
    {
        preorderTraversal(root);
        System.out.print("[END] \n");
    }

    public void printTreeLevel()
    {
        levelorderTraversal(root);
        System.out.print("[END] \n");
    }

    // (Root - Left - Right)
    private void preorderTraversal(Node<T> core) 
    {
        if (core == null)
        {
            return;
        }
        System.out.print(core.getStem() + " - ");
        preorderTraversal(core.getLeft());
        preorderTraversal(core.getRight());
    }

    // (Level, Queue printl)
    private void levelorderTraversal(Node<T> core) 
    {
        if (core == null)
        {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(core);

        while (!queue.isEmpty()) 
        {
            Node<T> temp = queue.poll();
            System.out.print(temp.getStem() + " - ");

            if (temp.getLeft() != null)
            {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null)
            {
                queue.offer(temp.getRight());
            }
        }
    }
}
