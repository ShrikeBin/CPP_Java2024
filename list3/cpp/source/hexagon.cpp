#include <hexagon.hpp>

#include <cmath>

Hexagon::Hexagon(const double input1);
:var1(input1)
{
}

const double Hexagon::area()
{
    return ((sqrt(3)*var1)*var1*3);
}

const double Hexagon::length()
{
    return (6*var1);
}