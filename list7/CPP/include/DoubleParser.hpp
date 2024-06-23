#ifndef DOUBLEPARSER_HPP
#define DOUBLEPARSER_HPP

#include <iostream>
#include <string>
#include <memory>
#include <stdexcept>
#include "CLI.hpp"
#include "Parser.hpp"

class DoubleParser : public Parser<double>
{
public:
    double parse(const std::string& input) const override
    {
        try
        {
            return std::stod(input);
        }
        catch (const std::invalid_argument& e)
        {
            throw std::invalid_argument("Invalid double: " + input);
        }
    }
};

#endif // DOUBLEPARSER_HPP
