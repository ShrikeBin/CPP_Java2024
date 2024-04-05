#include <factory.hpp>

#include <vector>
#include <string>
#include <stdexcept>

#include <utils.hpp>
#include <figure.hpp>
#include <circle.hpp>
#include <hexagon.hpp>
#include <pentagon.hpp>
#include <square.hpp>
#include <rectangle.hpp>
#include <rhombus.hpp>

static const Figure Factory::CreateShape(const Type type);
{
    switch (type.get_name())
    {
    case "Circle"
        return Circle(type.get_var()[0]);
    case "Hexagon"
        return Hexagon(type.get_var()[0]);
    case "Pentagon"
        return Pentagon(type.get_var()[0]);
    case "Square"
        return Square(type.get_var()[0]);
    case "Rectangle"
        return Rectangle(type.get_var()[0],type.get_var()[1]);
    case "Rhombus"
        return Rhombus(type.get_var()[0],type.get_var()[1]);
    default:
        throw std::invalid_argument(LOC()+"Unable to create shape")
    }
}