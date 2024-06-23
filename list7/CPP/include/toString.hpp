#ifndef TOSTRING_HPP
#define TOSTRING_HPP

#include <string>
#include <sstream>

template <typename T>
std::string toString(const T& value)
{
    std::ostringstream oss;
    oss << value;
    return oss.str();
}

#endif // TOSTRING_HPP
