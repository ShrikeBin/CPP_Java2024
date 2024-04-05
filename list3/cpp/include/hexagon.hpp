#ifndef HEXAGON_HPP
#define HEXAGON_HPP

#include <figure.hpp>

const class Hexagon : Figure
{
    public:
        Hexagon(const double input1);

    private:
        double var1;

    public:
        const double area();
        const double length();
};

#endif