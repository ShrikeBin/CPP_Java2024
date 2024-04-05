#ifndef TYPE_HPP
#define TYPE_HPP

#include <vector>
#include <string>

const class Type
{
    public:
        Type(std::vector<double> parameters, std::string name);
    
    private:
        std::vector<double> parameters;
        std::string name;

    public:
        std::vector<double> get_var();
        std::string get_name();
}

#endif