#ifndef FACTORY_HPP
#define FACTORY_HPP

#include <figure.hpp>
#include <type.hpp>

class Factory
{
    Factory()=delete;
    ~Factory()=delete;

    static const Figure CreateShape(const Type type);
};

#endif