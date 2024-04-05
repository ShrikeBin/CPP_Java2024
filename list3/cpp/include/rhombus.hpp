#ifndef RHOMBUS_HPP
#define RHOMBUS_HPP

#include <quadrilateral.hpp>

class Rhombus : public Quadrilateral
{
    public:
        Rhombus()=delete;
        Rhombus(const double input1, const double input2);

    private:
        double var1;
        double angle;

    public:
        double area() override;
        double length() override;
};

#endif