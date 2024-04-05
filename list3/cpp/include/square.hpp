#ifndef SQUARE_HPP
#define SQUARE_HPP

#include <quadrilateral.hpp>

class Square : public Quadrilateral
{
    public:
        Square()=delete;
        Square(const double input1);
        
    private:
        double var1;

    public:
        double area() override;
        double length() override;
};

#endif