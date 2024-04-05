#ifndef RECTANGLE_HPP
#define RECTANGLE_HPP

#include <quadrilateral.hpp>

class Rectangle : public Quadrilateral
{
    public:
        Rectangle()=delete;
        Rectangle(const double input1, const double input2);

    private:
        double var1;
        double var2;

    public:
        double area() override;
        double length() override;
};

#endif