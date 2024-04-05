#include <pentagon.hpp>

#include <cmath>

#define PI 3.141592653589

Pentagon::Pentagon(const double input1)
:var1(input1)
{
}

double Pentagon::area()
{
    return (5/2) * (1/(tan(36*PI/180))) * (var1/2) * var1;
}

double Pentagon::length()
{
    return (5*var1);
}