#ifndef RECTANGLE_HPP
#define RECTANGLE_HPP

#include <quadrilateral.hpp>

class Rectangle : Quadrilateral
{
public:

    Rectangle(const double input[]) noexcept(false);

    const double area() noexcept(true);
};

#endif