#ifndef PARSER_HPP
#define PARSER_HPP

#include <string>

template <typename T>
class Parser 
{
public:
    virtual ~Parser() = default;
    virtual T parse(const std::string& input) const = 0;
};

#endif // PARSER_HPP
