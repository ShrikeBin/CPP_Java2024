#ifndef RHOMBUS_HPP
#define RHOMBUS_HPP

#include <quadrilateral.hpp>

class Rhombus : Quadrilateral
{
public:

    Rhombus(const double input[], const double angle) noexcept(false);

    const double area() noexcept(true);

};

#endif