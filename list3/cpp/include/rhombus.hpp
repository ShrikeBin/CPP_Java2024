#ifndef RHOMBUS_HPP
#define RHOMBUS_HPP

#include <quadrilateral.hpp>

class Rhombus : Quadrilateral
{
    public:
        Rhombus(const double input1, const double input2);

    private:
        double var1;
        double angle;

    public:
        const double area();
        const double length();
};

#endif