#ifndef PENTAGON_HPP
#define PENTAGON_HPP

#include <figure.hpp>

class Pentagon : public Figure
{
    public:
        Pentagon()=delete;
        Pentagon(const double input1);

    private:
        double var1;

    public:
        const double area();
        const double length();
};

#endif