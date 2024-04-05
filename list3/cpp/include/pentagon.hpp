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
        double area() override;
        double length() override;
};

#endif