#ifndef INTPARSER_HPP
#define INTPARSER_HPP

#include <iostream>
#include <string>
#include <memory>
#include <stdexcept>
#include "CLI.hpp"
#include "Parser.hpp"

class IntParser : public Parser<int>
{
public:
    int parse(const std::string& input) const override
    {
        try
        {
            return std::stoi(input);
        }
        catch (const std::invalid_argument& e)
        {
            throw std::invalid_argument("Invalid integer: " + input);
        }
    }
};

#endif // INTPARSER_HPP