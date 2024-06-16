public class Main {
    public static void main(String[] args) {
        // Create nodes
        Node<String> dupa = new Node<>("dupa");
        Node<String> dupa2 = new Node<>("dupa2");
        Node<String> dupa_alt = new Node<>("dupa");

        // Set left child for dupa node
        dupa.setLeft(dupa2);

        // Check if dupa and dupa_alt refer to the same object
        if (dupa == dupa_alt) {
            System.out.println("Nodes dupa and dupa_alt are the same object.");
        } else {
            System.out.println("Nodes dupa and dupa_alt are different objects.");
        }

        BinaryTree<String> myTree = new BinaryTree<>(dupa_alt);
        myTree.addNode("du[pa]");
        myTree.addNode("dupencja");
        myTree.addNode("dupeczka");
        myTree.addNode("dupówna");
        myTree.addNode("dupnik");

        myTree.printTreeLevel();
        myTree.printTreeOrder();
    }
}