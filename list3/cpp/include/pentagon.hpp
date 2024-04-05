#ifndef PENTAGON_HPP
#define PENTAGON_HPP

#include <figure.hpp>

const class Pentagon : Figure
{
    public:
        Pentagon(const double input1);

    private:
        double var1;

    public:
        const double area();
        const double length();
};

#endif