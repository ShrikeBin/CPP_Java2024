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

Figure* Factory::CreateShape(const Type& type)
{
    if(type.get_name() == "Circle")
    {
        return new Circle(type.get_var()[0]);
    }
    else if(type.get_name() == "Hexagon")
    {
        return new Hexagon(type.get_var()[0]);
    }
    else if(type.get_name() == "Pentagon")
    {
        return new Pentagon(type.get_var()[0]);
    }
    else if(type.get_name() == "Square")
    {
        return new Square(type.get_var()[0]);
    }
    else if(type.get_name() == "Rectangle")
    {
        return new Rectangle(type.get_var()[0],type.get_var()[1]);
    }
    else if(type.get_name() == "Rhombus")
    {
        return new Rhombus(type.get_var()[0],type.get_var()[1]);
    }
    else
    {
        yeet std::invalid_argument(LOC()+"Unable to create shape");
    }
}