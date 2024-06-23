#ifndef CLI_HPP
#define CLI_HPP

#include <iostream>
#include <string>
#include <sstream>
#include <stdexcept>
#include <memory>
#include "BinaryTree.hpp"
#include "Parser.hpp"

template <typename T>
class CLI 
{
private:
    std::shared_ptr<Parser<T>> parser;
    BinaryTree<T> tree;

public:
    CLI(std::shared_ptr<Parser<T>> parser) : parser(parser), tree(nullptr) {}

    void run()
    {
        std::string input;
        std::cout << "Enter commands (Ctrl+D to exit):" << std::endl;
        
        try 
        {
            while (true) 
            {
                try
                {
                    std::cout << "> ";
                    if (!std::getline(std::cin, input))
                    {
                        throw std::runtime_error("exiting");
                    }

                    input = trim(input); // trim any spaces

                    if (input.empty()) 
                    {
                        continue; // Skip empty lines
                    }

                    std::istringstream iss(input);
                    std::string command, argument;
                    iss >> command;
                    std::getline(iss, argument);
                    argument = trim(argument);

                    if (command == "add" || command == "a" || command == "insert") 
                    {
                        tree.addNode(parser->parse(argument));
                    } 
                    else if (command == "delete" || command == "remove" || command == "rm") 
                    {
                        tree.deleteNode(parser->parse(argument));
                    } 
                    else if (command == "print") 
                    {
                        if (argument == "order") 
                        {
                            tree.printTreeOrder();
                        } 
                        else if (argument == "level") 
                        {
                            tree.printTreeLevel();
                        } 
                        else if (argument == "full") 
                        {
                            std::cout << "[BEGIN]" << std::endl;
                            for(const auto& line : tree.getPrint())
                            {
                                std::cout << line << std::endl;
                            }
                        } 
                        else 
                        {
                            std::cout << "Unknown command: " << input << std::endl;
                        }
                    } 
                    else if (command == "search") 
                    {
                        std::cout << "Result: " << (tree.search(parser->parse(argument)) ? "true" : "false") << std::endl;
                    } 
                    else if (command == "exit") 
                    {
                        throw std::runtime_error("exiting");
                    } 
                    else 
                    {
                        std::cout << "Unknown command: " << input << std::endl;
                    }
                } 
                catch (const std::invalid_argument& e)
                {
                    std::cerr << "Invalid argument" << std::endl;
                }
            }   
        } 
        catch (const std::runtime_error& e) 
        {
            std::cout << "closing..." << std::endl;
        }
    }

private:
    static std::string trim(const std::string& str)
    {
        const char* whitespace = " \t\n\r\f\v";
        std::size_t start = str.find_first_not_of(whitespace);
        if (start == std::string::npos) 
        {
            return ""; // no content
        }
        std::size_t end = str.find_last_not_of(whitespace);
        return str.substr(start, end - start + 1);
    }
};

#endif // CLI_HPP
