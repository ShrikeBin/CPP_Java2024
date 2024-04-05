#include <utils.hpp>

#include <string>
#include <stdexcept>
#include <vector>
#include <algorithm>
#include <iostream>

#include <type.hpp>

Type Utils::input_recognition(const int& argr, const char* const argv[]) noexcept(false)
{
    
    if(!((argr == 3) || (argr == 7)))
    {
        throw std::invalid_argument(LOC()+"invalid amount of arguments: "+ std::to_string(argr));
    }


    std::vector<std::string> arguments;

    for(int i = 1; i < argr; i++)
    {
        arguments.push_back(std::string(argv[i]));
    }


    if (!(arguments[0] == "Q" || arguments[0] == "P" || arguments[0] == "H" || arguments[0] == "C")) 
    {
    throw std::invalid_argument(LOC() + "Unable to recognize figure code: " + arguments[0]);
    }
    else if ((arguments[0] == "P" || arguments[0] == "H" || arguments[0] == "C") && !(argr == 3)) 
    {
    throw std::invalid_argument(LOC() + "Simple shapes input only one argument");
    }
    else if (arguments[0] == "Q" && !(argr == 7)) 
    {
    throw std::invalid_argument(LOC() + "Quadrilateral inputs four sides and an angle");
    }


    std::vector<double> input;


    for(int i = 1; i < arguments.size(); i++)
    {
        if (std::stod(arguments[i]) < 0)
        {
            throw std::invalid_argument(LOC() + "None of the arguments can be negative");
        }

        input.push_back(std::stod(arguments[i]));
    }

    if (arguments[0] == "C") 
    {
        return Type(input, "Circle");
    } 
    else if (arguments[0] == "P") 
    {
        return Type(input, "Pentagon");
    } 
    else if (arguments[0] == "H") 
    {
        return Type(input, "Hexagon");
    } 
    else
    {
        if(input[4]>=180)
        {
            throw std::invalid_argument(LOC()+"That is an invalid angle for a Rhombus" + std::to_string(input[4]));
        }

        std::sort(input.begin(),input.end()); //proszę zadziałaj xd

        if(input[0]==input[1]&&input[1]==input[2]&&input[2]==input[3]&&input[4]==90) //all sides same and angle 90
        {
            return Type({input[0]}, "Square");
        }
        else if(input[0]==input[1]&&input[1]==input[2]&&input[2]==input[3]&&input[4]!=90) //all sides same and angle !90
        {
            return Type({input[0],input[4]}, "Rhombus");
        }
        else if(input[0]==input[1]&&input[2]==input[3]&&input[4]==90) //two sets of different sides and angle 90
        {
            return Type({input[0],input[2]}, "Rectangle");
        }
        else
        {
            throw std::invalid_argument(LOC()+"Unable to recognize figure based on the input values");
        } 
    }
}
