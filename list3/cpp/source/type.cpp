#include <type.hpp>

#include <vector>
#include <string>

Type::Type(std::vector<double> parameters_in, std::string name_in)
:parameters(parameters_in), name(name_in)
{
}

std::vector<double> Type::get_var();
{
    return parameters;
}

std::string Type::get_name();
{
    return name;
}