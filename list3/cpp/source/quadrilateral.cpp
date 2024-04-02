#include <quadrilateral.hpp>

#include <stdexcept>

#include <utils.hpp>

Quadrilateral::Quadrilateral(const double input[], const double angle)
{
    if(sizeof(input)!=4)
    {
        throw std::out_of_range()
    }
}


const double Quadrilateral::lenght()
{
    return sides[0] + sides[1] + sides[2] + sides[3];
}