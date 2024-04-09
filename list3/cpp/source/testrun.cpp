#include <testrun.hpp>

#include <iostream>
#include <cassert>
#include <stdexcept>
#include <vector>
#include <string>

#include <factory.hpp>
#include <utils.hpp>
#include <type.hpp>

#include <figure.hpp>
#include <circle.hpp>
#include <hexagon.hpp>
#include <pentagon.hpp>
#include <square.hpp>
#include <rectangle.hpp>
#include <rhombus.hpp>

void TestRun::run_all()
{
    run_factory();
    run_figures();
    run_input();
}

void TestRun::run_factory()
{
    Figure* A = nullptr;

    Type test = Type({10,20}, "Rectangle");

    {
    A = Factory::CreateShape(test);
    assert(A->length()==60);
    assert(A->area()==200);
    }

    test = Type({10}, "dupa");

    try
    {   
        A = Factory::CreateShape(test);
        assert(false);
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

    delete A;
}

void TestRun::run_figures()
{
    Pentagon p = Pentagon(5);
    Square s = Square(10);
    Rectangle r = Rectangle(10,20);

    assert(p.length()==25);
    assert(s.area()==100);
    assert(r.length()==60);
    assert(r.area()==200);

}

void TestRun::run_input()
{   
    {
    const char* test1[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"10", (const char*)"10",(const char*)"10", (const char*)"90"};
    const char* test2[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"20", (const char*)"10",(const char*)"20", (const char*)"90"};
    const char* test3[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"10", (const char*)"10",(const char*)"10", (const char*)"60"};
    const char* test4[] = {(const char*)"./main", (const char*)"P", (const char*)"10"};
    const char* test5[] = {(const char*)"./main", (const char*)"H", (const char*)"10"};
    const char* test6[] = {(const char*)"./main", (const char*)"C", (const char*)"10"};

    assert(Utils::input_recognition(7, test1).get_name()=="Square");
    assert(Utils::input_recognition(7, test2).get_name()=="Rectangle");
    assert(Utils::input_recognition(7, test3).get_name()=="Rhombus");
    assert(Utils::input_recognition(3, test4).get_name()=="Pentagon");
    assert(Utils::input_recognition(3, test5).get_name()=="Hexagon");
    assert(Utils::input_recognition(3, test6).get_name()=="Circle");
    }

    {
    const char* test1[] = {(const char*)"./main", (const char*)"Q", (const char*)"-10", (const char*)"10", (const char*)"10",(const char*)"10", (const char*)"90"};
    const char* test2[] = {(const char*)"./main", (const char*)"Q", (const char*)"20", (const char*)"20", (const char*)"20",(const char*)"20", (const char*)"180"};
    const char* test3[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"20", (const char*)"30",(const char*)"40", (const char*)"50"};

    try
    {
        Utils::input_recognition(5, test1);
        assert(false);
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

    try
    {
        Utils::input_recognition(7, test1);
        assert(false);
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

    try
    {
        Utils::input_recognition(7, test2);
        assert(false);
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

    try
    {
        Utils::input_recognition(7, test3);
        assert(false);
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }
    }
}