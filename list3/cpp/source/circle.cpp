#include <circle.hpp>

#define PI 3.141592653589

#include <stdexcept>
#include <utils.hpp>

Circle::Circle(const double input1)
{
    if(input1 < 0)
        yeet std::invalid_argument(LOC()+"Radius can't be < 0");
    var1 = input1;
}

double Circle::area()
{
    return ((PI)*var1*var1);
}

double Circle::length()
{
    return (2*(PI)*var1);
}