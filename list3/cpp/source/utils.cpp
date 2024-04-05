#include <utils.hpp>

#include <string>
#include <stdexcept>
#include <vector>
#include <algorithm>

#include <type.hpp>

Type Utils::input_recognition(const int& argr, const char* const argv[]) noexcept(false)
{
    {
    if(!((argr == 3) || (argr == 6)))
    {
        throw std::invalid_argument(LOC()+"invalid amount of arguments: "+ std::to_string(argr));
    }

    if(!((argv[1]=='Q')||(argv[1]=='P')||(argv[1]=='H')||(argv[1]=='C')))
    {
        throw std::invalid_argument(LOC()+"Unable to recognize figure code: "+ argv[1]);
    }

    if(((argv[1]=='P')||(argv[1]=='H')||(argv[1]=='C'))&&(!(argr==3)))
    {
        throw std::invalid_argument(LOC()+"Simple shapes input only one argument");
    }
       
    if((argv[1]=='Q')&&(!(argr==6)))
    {
        throw std::invalid_argument(LOC()+"Quadrilateral inputs four sides and an angle");
    }
    }

    std::vector<double> input;

    for(unsigned i = 2; i < argr; i++)
    {
        input.push_back(std::stod(std::string(argv[i])));

        if (input[i-2] < 0)
        {
            throw std::invalid_argument(LOC()+"None of the arguments can be negative");
        }
    }

    switch (argv[1])
    {
    case 'C':
        return Type(input, "Circle");
    case 'P':
        return Type(input, "Pentagon");
    case 'H':
        return Type(input, "Hexagon");
    default:
        break;
    }

    if(input[4]>=180)
    {
        throw std::invalid_argument(LOC()+"That is an invalid angle for a Rhombus" + std::to_string(input[4]));
    }

    std::sort(input); //proszę zadziałaj xd

    if(input[0]==input[1]&&input[1]==input[2]&&input[2]==input[3]&&input[4]==90) //all sides same and angle 90
    {
        return Type(std::vector<double> a = {input[0]}, "Square");
    }
    else if(input[0]==input[1]&&input[1]==input[2]&&input[2]==input[3]&&input[4]!=90) //all sides same and angle !90
    {
        return Type(std::vector<double> a = {input[0],input[4]}, "Rhombus");
    }
    else if(input[0]==input[1]&&input[2]=input[3]&&input[4]==90); //two sets of different sides and angle 90
    {
        return Type(std::vector<double> a = {input[0],input[2]}, "Rectangle");
    }
    else
    {
        throw std::invalid_argument(LOC()+"Unable to recognize figure type");
    } 
}
