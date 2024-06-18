#include <BinaryTree.hpp>
#include <iostream>
#include <queue>    
#include <memory> //shared_ptr
#include <Node.hpp>

int main() 
{
    BinaryTree<int> tree(std::make_shared<Node<int>>(1));

    tree.addNode(2);
    tree.addNode(3);
    tree.addNode(4);
    tree.addNode(5);

    std::cout << "Tree in Preorder: ";
    tree.printTreeOrder();

    std::cout << "Tree in Level Order: ";
    tree.printTreeLevel();

    tree.deleteNode(3);
    
    std::cout << "Tree after deleting node 3 in Preorder: ";
    tree.printTreeOrder();

    std::cout << "Tree after deleting node 3 in Level Order: ";
    tree.printTreeLevel();

    return 0;
}
