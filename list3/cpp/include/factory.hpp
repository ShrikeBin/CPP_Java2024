#ifndef FACTORY_HPP
#define FACTORY_HPP

#include <figure.hpp>
#include <type.hpp>

class Factory
{
    Factory()=delete;
    ~Factory()=delete;
    
public:
    static Figure* CreateShape(const Type& type) noexcept(false);
};

#endif