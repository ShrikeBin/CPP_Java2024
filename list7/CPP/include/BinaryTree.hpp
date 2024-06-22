#ifndef BINARYTREE_HPP
#define BINARYTREE_HPP

#include <iostream>
#include <queue>
#include <memory> // for std::shared_ptr

template <typename T>
class BinaryTree 
{
private:
    class Node 
    {
        T stem;
        std::shared_ptr<Node> left;
        std::shared_ptr<Node> right;

        Node(T input) : stem(input), left(nullptr), right(nullptr) {}
    };

    std::shared_ptr<Node> root;

    std::shared_ptr<Node> deleteAsBaseOn(std::shared_ptr<Node> root, T keyData) 
    {
        if (root == nullptr) 
        {
            return root;
        }

        if (keyData < root->stem) 
        {
            root->left = deleteAsBaseOn(root->left, keyData);
        }
        else if (keyData > root->stem)
        {
            root->right = deleteAsBaseOn(root->right, keyData);
        }
        else 
        {
            // Node with only one child or no child
            if (root->left == nullptr)
            {
                return root->right;
            }
            else if (root->right == nullptr)
            {
                return root->left;
            }

            // Node with two children
            root->stem = smallestLeftTree(root->right);
            root->right = deleteAsBaseOn(root->right, root->stem);
        }

        return root;
    }

    T smallestLeftTree(std::shared_ptr<Node> root) 
    {
        T min = root->stem;
        while (root->left != nullptr) 
        {
            min = root->left->stem;
            root = root->left;
        }
        return min;
    }

    void preorderTraversal(const std::shared_ptr<Node>& core) const
    {
        if (core == nullptr) 
        {
            return;
        }
        std::cout << core->stem << " - ";
        preorderTraversal(core->left);
        preorderTraversal(core->right);
    }

    void levelorderTraversal(const std::shared_ptr<Node>& core) const
    {
        if (core == nullptr) 
        {
            return;
        }

        std::queue<std::shared_ptr<Node>> queue;
        queue.push(core);

        while (!queue.empty()) 
        {
            auto temp = queue.front();
            queue.pop();
            std::cout << temp->stem << " - ";

            if (temp->left != nullptr) 
            {
                queue.push(temp->left);
            }
            if (temp->right != nullptr) 
            {
                queue.push(temp->right);
            }
        }
    }

public:
    BinaryTree(std::shared_ptr<Node> root = nullptr) : root(root) {}

    std::shared_ptr<Node> getRoot() const 
    {
        return root;
    }

    void addNode(T parentData)
    {
        auto input = std::make_shared<Node>(parentData);

        if (root == nullptr) 
        {
            root = input;
        } 
        else 
        {
            auto temp = root;
            std::shared_ptr<Node> prev = nullptr;

            while (temp != nullptr) 
            {
                prev = temp;
                if (temp->stem > parentData) 
                {
                    temp = temp->left;
                }
                else if (temp->stem < parentData) 
                {
                    temp = temp->right;
                }
                else
                {
                    return; // Duplicate value, do not add the node
                }
            }
            if (prev->stem > parentData)
            {
                prev->left = input;
            }
            else
            {
                prev->right = input;
            }
        }
    }

    void deleteNode(T keyData) 
    {
        this->root = deleteAsBaseOn(this->root, keyData);
    }

    void printTreeOrder() const 
    {
        preorderTraversal(root);
        std::cout << "[END] \n";
    }

    void printTreeLevel() const 
    {
        levelorderTraversal(root);
        std::cout << "[END] \n";
    }
};

#endif // BINARYTREE_HPP
