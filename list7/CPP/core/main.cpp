#include <iostream>
#include <string>
#include <memory>
#include <stdexcept>
#include "CLI.hpp"
#include "Parser.hpp"
#include <IntParser.hpp>
#include <DoubleParser.hpp>
#include <StringParser.hpp>


int main()
{
    std::string typeInput;
    std::cout << "Enter type T (e.g., int, string, double): ";
    std::getline(std::cin, typeInput);
    try
    {
        if (typeInput == "int" || typeInput == "integer")
        {
            std::shared_ptr<Parser<int>> intParser = std::make_shared<IntParser>();
            CLI<int> cli(intParser);
            cli.run();
        }
        else if (typeInput == "string")
        {
            std::shared_ptr<Parser<std::string>> stringParser = std::make_shared<StringParser>();
            CLI<std::string> cli(stringParser);
            cli.run();
        }
        else if (typeInput == "double")
        {
            std::shared_ptr<Parser<double>> doubleParser = std::make_shared<DoubleParser>();
            CLI<double> cli(doubleParser);
            cli.run();
        }
        else
        {
            std::cout << "Unknown Type, closing..." << std::endl;
        }
    }
    catch (const std::invalid_argument& e)
    {
        std::cerr << "Invalid argument: " << e.what() << std::endl;
    }
    catch (const std::out_of_range& e)
    {
        std::cerr << "Out of range error: " << e.what() << std::endl;
    }
    catch (const std::exception& e)
    {
        std::cerr << "An error occurred: " << e.what() << std::endl;
    }
    
    return 0;
}
