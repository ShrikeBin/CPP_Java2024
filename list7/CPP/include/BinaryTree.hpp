#ifndef BINARYTREE_HPP
#define BINARYTREE_HPP

#include <iostream>
#include <queue>
#include <memory>
#include <vector>
#include "toString.hpp"

template <typename T>
class BinaryTree 
{
private:
    class Node 
    {
    public:
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
            if (root->left == nullptr)
            {
                return root->right;
            }
            else if (root->right == nullptr)
            {
                return root->left;
            }

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

    bool searchAsBase(const std::shared_ptr<Node>& node, T value) const
    {
        if (node == nullptr)
        {
            return false;
        }

        if(value < node->stem)
        {
            return searchAsBase(node->left, value);
        }
        else if(value > node->stem)
        {
            return searchAsBase(node->right, value);
        }
        else
        {
            return true;
        }
    }

    void printRec(const std::shared_ptr<Node>& node, const std::string& prefix, bool isTail, std::vector<std::string>& lines) const
    {
        if (node == nullptr)
        {
            return;
        }

        lines.push_back(prefix + (isTail ? "^-- " : "|-- ") + toString(node->stem));

        std::vector<std::shared_ptr<Node>> children;
        
        if(node->left != nullptr)
        {
            children.push_back(node->left);
        }
        if(node->right != nullptr)
        {
            children.push_back(node->right);
        }

        for(size_t i = 0; i < children.size(); ++i)
        {
            printRec(children[i], prefix + (isTail ? "    " : "|   "), i == children.size() - 1, lines);
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
                    return;
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

    bool search(T value) const
    {
        return searchAsBase(root, value);
    }

    std::vector<std::string> getPrint() const
    {
        std::vector<std::string> lines;
        printRec(root, "", true, lines);
        return lines;
    }
};

#endif // BINARYTREE_HPP
