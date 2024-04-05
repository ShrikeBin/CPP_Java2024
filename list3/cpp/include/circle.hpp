#ifndef CIRCLE_HPP
#define CIRCLE_HPP

#include <figure.hpp>

const class Circle : Figure
{
    public:
        Circle(const double input1);

    private:
        double var1;

    public:
        const double area();
        const double length();
};

#endif