#ifndef QUADRILATERAL_HPP
#define QUADRILATERAL_HPP

#include <figure.hpp>

class Quadrilateral : public Figure 
{
protected:
    virtual const double area();
    virtual const double length();
};

#endif