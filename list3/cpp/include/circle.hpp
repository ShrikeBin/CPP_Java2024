#ifndef CIRCLE_HPP
#define CIRCLE_HPP

#include <figure.hpp>

class Circle : public Figure
{
    public:
        Circle()=delete;
        Circle(const double input1); 

    private:
        double var1;

    public:
        const double area();
        const double length();
};

#endif