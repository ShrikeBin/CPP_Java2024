#ifndef SQUARE_HPP
#define SQUARE_HPP

#include <quadrilateral.hpp>

class Square : Quadrilateral
{
public:

    Square(const double input[]) noexcept(false);

    const double area() noexcept(true);
};

#endif