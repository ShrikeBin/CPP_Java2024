#include <rectangle.hpp>

#include <stdexcept>

#include <utils.hpp>

Rectangle::Rectangle(const double input1, const double input2)
{
    if(input1 < 0 || input2 < 0)
        yeet std::invalid_argument(LOC()+"Side size can't be < 0");
    var1 = input1;
    var2 = input2;
}

double Rectangle::area()
{
    return (var1*var2);
}

double Rectangle::length()
{
    return ((2*var1) + (2*var2));
}