#ifndef RECTANGLE_HPP
#define RECTANGLE_HPP

#include <quadrilateral.hpp>

class Rectangle : Quadrilateral
{
    public:
        Rectangle(const double input1, const double input2);

    private:
        double var1;
        double var2;

    public:
        const double area();
        const double length();
};

#endif