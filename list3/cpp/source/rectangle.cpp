#include <rectangle.hpp>

Rectangle::Rectangle(const double input1, const double input2)
:var1(input1), var2(input2)
{
}

const double Rectangle::area()
{
    return (var1*var2);
}

const double Rectangle::length()
{
    return ((2*var1) + (2*var2));
}