#ifndef QUADRILATERAL_HPP
#define QUADRILATERAL_HPP

#include <figure.hpp>

class Quadrilateral : public Figure 
{
public:
    virtual ~Quadrilateral() override {}

public:
    virtual double area() override = 0;
    virtual double length() override = 0;
};

#endif