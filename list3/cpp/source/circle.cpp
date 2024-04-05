#include <circle.hpp>

#define PI 3.141592653589

Circle::Circle(const double input1)
:var1(input1)
{
}

double Circle::area()
{
    return ((PI)*var1*var1);
}

double Circle::length()
{
    return (2*(PI)*var1);
}