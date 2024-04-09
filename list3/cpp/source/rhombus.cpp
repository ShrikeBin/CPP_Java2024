#include <rhombus.hpp>

#define PI 3.141592653589

#include <cmath>
#include <stdexcept>

#include <utils.hpp>

Rhombus::Rhombus(const double input1, const double input2)
{
    if(input1 < 0 || input2 < 0 || input2 > 180)
        yeet std::invalid_argument(LOC()+"Invalid input for Rhombus");
    var1 = input1;
    angle = input2;
}


double Rhombus::area()
{
    return (std::sin(angle*PI/180)) * var1 * var1;
}

double Rhombus::length()
{
    return (4*var1);
}