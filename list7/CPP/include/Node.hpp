#ifndef NODE_HPP
#define NODE_HPP

#include <memory> //shared_ptr

template <typename T>
class Node 
{
public:
    T stem;
    std::shared_ptr<Node<T>> left;
    std::shared_ptr<Node<T>> right;

    Node(T input) : stem(input), left(nullptr), right(nullptr) {}
};

#endif // NODE_HPP
