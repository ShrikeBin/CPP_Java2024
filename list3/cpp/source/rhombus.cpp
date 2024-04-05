#include <rhombus.hpp>

#include <cmath>

#define PI 3.141592653589

Rhombus::Rhombus(const double input1, const double input2)
:var1(input1), angle(input2)
{
}

double Rhombus::area()
{
    return (sin(angle*PI/180)) * var1 * var1;
}

double Rhombus::length()
{
    return (4*var1);
}