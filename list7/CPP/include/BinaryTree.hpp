#ifndef BINARYTREE_HPP
#define BINARYTREE_HPP

#include <iostream>
#include <queue>    
#include <memory> //shared_ptr
#include <Node.hpp>

template <typename T>
class BinaryTree 
{
private:
    std::shared_ptr<Node<T>> root;

    void deleteDeepest(std::shared_ptr<Node<T>> keyNode)
    {
        if (root == nullptr) 
        {
            return;
        }

        std::queue<std::shared_ptr<Node<T>>> queue;
        queue.push(root);
        std::shared_ptr<Node<T>> tempNode = nullptr;

        while (!queue.empty()) 
        {
            tempNode = queue.front();
            queue.pop();

            if (tempNode == keyNode) 
            {
                tempNode = nullptr;
                keyNode = nullptr;
                return;
            }
            if (tempNode->right != nullptr) 
            {
                if (tempNode->right == keyNode) 
                {
                    tempNode->right = nullptr;
                    keyNode = nullptr;
                    return;
                } 
                else 
                {
                    queue.push(tempNode->right);
                }
            }
            if (tempNode->left != nullptr) 
            {
                if (tempNode->left == keyNode) 
                {
                    tempNode->left = nullptr;
                    keyNode = nullptr;
                    return;
                } 
                else 
                {
                    queue.push(tempNode->left);
                }
            }
        }
    }

    void preorderTraversal(const std::shared_ptr<Node<T>>& core) const
    {
        if (core == nullptr) 
        {
            return;
        }
        std::cout << core->stem << " - ";
        preorderTraversal(core->left);
        preorderTraversal(core->right);
    }

    void levelorderTraversal(const std::shared_ptr<Node<T>>& core) const
    {
        if (core == nullptr) 
        {
            return;
        }

        std::queue<std::shared_ptr<Node<T>>> queue;
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
    BinaryTree(std::shared_ptr<Node<T>> root = nullptr) : root(root) {}

    std::shared_ptr<Node<T>> getRoot() const 
    {
        return root;
    }

    void addNode(T parentData)
    {
        auto input = std::make_shared<Node<T>>(parentData);

        if (root == nullptr) 
        {
            root = input;
        } 
        else 
        {
            std::queue<std::shared_ptr<Node<T>>> queue;
            queue.push(root);

            while (!queue.empty()) 
            {
                auto tempNode = queue.front();
                queue.pop();

                if (tempNode->left == nullptr) 
                {
                    tempNode->left = input;
                    break;
                }
                else if (tempNode->right == nullptr) 
                {
                    tempNode->right = input;
                    break;
                } 
                else 
                {
                    queue.push(tempNode->left);
                    queue.push(tempNode->right);
                }
            }
        }
    }

    void deleteNode(T keyData) 
    {
        if (root == nullptr) 
        {
            return;
        }

        std::queue<std::shared_ptr<Node<T>>> queue;
        queue.push(root);
        std::shared_ptr<Node<T>> tempNode = nullptr;
        std::shared_ptr<Node<T>> keyNode = nullptr;

        while (!queue.empty()) 
        {
            tempNode = queue.front();
            queue.pop();

            if (tempNode->stem == keyData) 
            {
                keyNode = tempNode;
            }
            if (tempNode->left != nullptr) 
            {
                queue.push(tempNode->left);
            }
            if (tempNode->right != nullptr) 
            {
                queue.push(tempNode->right);
            }
        }

        if (keyNode != nullptr) 
        {
            T deepestNodeData = tempNode->stem;
            keyNode->stem = deepestNodeData;
            deleteDeepest(tempNode);
        }
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

