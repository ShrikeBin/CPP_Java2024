#include <square.hpp>

Square::Square(const double input1)
:var1(input1)
{
}

double Square::area()
{
    return (var1*var1);
}

double Square::length()
{
    return (4*var1);
}