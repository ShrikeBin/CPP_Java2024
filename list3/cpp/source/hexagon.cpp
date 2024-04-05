#include <hexagon.hpp>

#include <cmath>
#include <stdexcept>
#include <utils.hpp>

Hexagon::Hexagon(const double input1)
{
    if(input1 < 0)
        yeet std::invalid_argument(LOC()+"Side size can't be < 0");
    var1 = input1;
}

double Hexagon::area()
{
    return ((sqrt(3)*var1)*var1*3);
}

double Hexagon::length()
{
    return (6*var1);
}