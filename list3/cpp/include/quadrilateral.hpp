#ifndef QUADRILATERAL_HPP
#define QUADRILATERAL_HPP

#include <figure.hpp>

class Quadrilateral : Figure //co z destruktorem i konstruktorem? (chyba nic?)
{
protected:

    Quadrilateral(const double input[], const double angle) noexcept(false);

    double sides[4];
    double angle;

    const double lenght();

};

#endif