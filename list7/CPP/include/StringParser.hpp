#ifndef STRINGPARSER_HPP
#define STRINGPARSER_HPP

#include <iostream>
#include <string>
#include <memory>
#include <stdexcept>
#include "CLI.hpp"
#include "Parser.hpp"

class StringParser : public Parser<std::string>
{
public:
    std::string parse(const std::string& input) const override
    {
        return input;
    }
};

#endif // STRINGPARSER_HPP