#include <pentagon.hpp>

#define PI 3.141592653589

#include <cmath>
#include <stdexcept>
#include <utils.hpp>

Pentagon::Pentagon(const double input1)
{
    if(input1 < 0)
        yeet std::invalid_argument(LOC()+"Side size can't be < 0");
    var1 = input1;
}

double Pentagon::area()
{
    return (5/2) * (1/(std::tan(36*PI/180))) * (var1/2) * var1;
}

double Pentagon::length()
{
    return (5*var1);
}