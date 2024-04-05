#ifndef UTILS_HPP
#define UTILS_HPP

#include <string>
#include <type.hpp>

#define LOC() std::string(__FILE__) + ":" + std::to_string(__LINE__) + " [ " + std::string(__func__) + " ] "

class Utils
{
    Utils() = delete;
    ~Utils() = delete;

    public:
        static Type input_recognition(const int& argr, const char* const argv[]) noexcept(false);

};

#endif