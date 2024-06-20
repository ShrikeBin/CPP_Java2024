import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> 
{
    private class Node<T>
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
            Node<T> prev = null;
            Node<T> temp = root;

            while (temp != null) 
            {
                if (temp.getStem() > parentData) {
                    prev = temp;
                    temp = temp.getLeft();
                }
                else if (temp.getStem() < parentData) {
                    prev = temp;
                    temp = temp.getRight();
                }
            }
            if (prev.getStem() > parentData)
            {
                prev.setLeft(input);
            }
            else
            {
                prev..setRight(input);
            }
        }
    }

    public void deleteNode(T keyData) //deletes the Nodes of a given key
    {
        deleteAsRoot(this.root, keyData);
    }

    private void deleteAsRoot(Node <T> root ,T keyData) 
    {
        if (root == null) 
        {
            return;
        }

        if (keyData < root.getStem()) 
        {
            deleteAsRoot(root.getLeft(), keyData);
        }
        else if (keyData > root.getStem())
        {
            deleteAsRoot(root.getRight(), keyData);
        }
        else 
        {
            // Node with only one child
            if(!((root.getLeft() == null)&&(root.getRight() == null)))
            {
                if (root.getLeft() == null) 
                {
                    root = root.getRight();
                    return;
                } 
                else if (root.getRight() == null) 
                {
                    root = root.getLeft();
                    return;
                }
            }
            // Node with no child
            else if((root.getLeft() == null)&&(root.getRight() == null))
            {
                root = null;
            }
            // Node with 2 children
            else
            {
                root.setStem(smallestSuccesor(root.right));

                deleteAsRoot(root.getRight(), root.getStem());
            }
        }
    }

    private T smallestSuccesor(Node<T> root) 
    {
        T minv = root.getStem();
        while (root.getLeft() != null) 
        {
            minv = root.getLeft().getStem();
            root = root.getLeft();
        }
        return minv;
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
