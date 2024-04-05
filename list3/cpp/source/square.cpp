#include <square.hpp>

#include <stdexcept>

#include <utils.hpp>

Square::Square(const double input1)
{
    if(input1 < 0)
        yeet std::invalid_argument(LOC()+"Side size can't be < 0");
    var1 = input1;
}

double Square::area()
{
    return (var1*var1);
}

double Square::length()
{
    return (4*var1);
}