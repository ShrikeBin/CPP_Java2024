#include <iostream>
#include <stdexcept>
#include <string>
#include <stdlib.h>
#include <stdexcept>

#include <utils.hpp>
#include <factory.hpp>
#include <figure.hpp>

int main(const int argr, const char* const argv[])
{
    if(argr <= 1)
    {
        std::cout<<"Usage: ./main <figure code (Q - quadrilateral, C - cirlcle, P - pentagon, H - hexagon)>; for Quadrilateral <side1> <side2> <side3> <side4> <angle>; for Circle <radious>; for Pentagon & Hexagon <side1> || note that all additional arguments will be ignored."<<std::endl;
        return -1;
    }

    Figure* A = NULL;

    try
    {
        A = Factory::CreateShape(Utils::input_recognition(argr, argv));
        std::cout<<Utils::input_recognition(argr, argv).get_name()<<" ";
        std::cout<<"Area: "<< A->area()<<" ";
        std::cout<<"Circumference: "<< A->length();
    }   
    catch (const std::invalid_argument& e)
    {
        std::cerr<<e.what()<<std::endl;
    }

    delete A;
}