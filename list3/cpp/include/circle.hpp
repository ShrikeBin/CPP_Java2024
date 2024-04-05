#ifndef CIRCLE_HPP
#define CIRCLE_HPP

#include <figure.hpp>

class Circle : public Figure
{
    public:
        Circle()=delete;
        Circle(const double input1) noexcept(false);

    private:
        double var1;

    public:
        double area() override;
        double length() override;
};

#endif