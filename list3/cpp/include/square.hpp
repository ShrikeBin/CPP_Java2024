#ifndef SQUARE_HPP
#define SQUARE_HPP

#include <quadrilateral.hpp>

class Square : Quadrilateral
{
    private:
        double var1;

    public:
        const double area();
        const double length();
};

#endif