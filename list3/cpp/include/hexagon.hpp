#ifndef HEXAGON_HPP
#define HEXAGON_HPP

#include <figure.hpp>

class Hexagon : public Figure
{
    public:
        Hexagon()=delete;
        Hexagon(const double input1) noexcept(false);

    private:
        double var1;

    public:
        double area() override;
        double length() override;
};

#endif