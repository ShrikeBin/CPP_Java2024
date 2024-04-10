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
    {
        Figure* A = nullptr;
        Type test = Type({10,20}, "Rectangle");
        A = Factory::CreateShape(test);
        assert(A->length() == 60);
        assert(A->area() == 200);
        delete A;
    }

    {
        Figure* A = nullptr;
        Type test = Type({5}, "Circle");
        A = Factory::CreateShape(test);
        assert(A->area() < 79); // Approximate circle with radius 5
        assert(A->length() < 32); // Approximate circle with radius 5
        delete A;
    }

    {
        Figure* A = nullptr;
        Type test = Type({5}, "Pentagon");
        A = Factory::CreateShape(test);
        assert(A->area() < 62); // Approximate pentagon with side length 5
        assert(A->length() == 25);
        delete A;
    }

    {
        Figure* A = nullptr;
        Type test = Type({6}, "Hexagon");
        A = Factory::CreateShape(test);
        assert(A->area() < 94); // Approximate hexagon with side length 6
        assert(A->length() == 36);
        delete A;
    }

    {
        Figure* A = nullptr;
        Type test = Type({10}, "InvalidShape");
        try {
            A = Factory::CreateShape(test);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }
        delete A;
    }
}

void TestRun::run_figures() 
{
    {
        Rhombus rh = Rhombus(10, 60);
        assert(rh.area() < 87);
        assert(rh.length() == 40);

        Square s = Square(10);
        assert(s.area() == 100);
        assert(s.length() == 40);

        Rectangle r = Rectangle(10, 20);
        assert(r.area() == 200);
        assert(r.length() == 60);

        Circle c = Circle(5);
        assert(c.area() < 79); // Approximate circle with radius 5
        assert(c.length() < 32); // Approximate circle with radius 5

        Pentagon p = Pentagon(5);
        assert(p.area() < 62); // Approximate pentagon with side length 5
        assert(p.length() == 25);

        Hexagon h = Hexagon(6);
        assert(h.area() < 94); // Approximate hexagon with side length 6
        assert(h.length() == 36);
    }
}

void TestRun::run_input() 
{
    {
        const char* test1[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"10", (const char*)"10",(const char*)"10", (const char*)"90"};
        const char* test2[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"20", (const char*)"10",(const char*)"20", (const char*)"90"};
        const char* test3[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"10", (const char*)"10",(const char*)"10", (const char*)"60"};

        assert(Utils::input_recognition(7, test1).get_name()=="Square");
        assert(Utils::input_recognition(7, test2).get_name()=="Rectangle");
        assert(Utils::input_recognition(7, test3).get_name()=="Rhombus");


        const char* test4[] = {(const char*)"./main", (const char*)"P", (const char*)"10"};
        const char* test5[] = {(const char*)"./main", (const char*)"H", (const char*)"10"};
        const char* test6[] = {(const char*)"./main", (const char*)"C", (const char*)"10"};

        assert(Utils::input_recognition(3, test4).get_name()=="Pentagon");
        assert(Utils::input_recognition(3, test5).get_name()=="Hexagon");
        assert(Utils::input_recognition(3, test6).get_name()=="Circle");
    }


    {
        const char* test1[] = {(const char*)"./main", (const char*)"Q", (const char*)"-10", (const char*)"10", (const char*)"10",(const char*)"10", (const char*)"90"};
        const char* test2[] = {(const char*)"./main", (const char*)"Q", (const char*)"20", (const char*)"20", (const char*)"20",(const char*)"20", (const char*)"180"};
        const char* test3[] = {(const char*)"./main", (const char*)"Q", (const char*)"10", (const char*)"20", (const char*)"30",(const char*)"40", (const char*)"50"};

        try {
            Utils::input_recognition(7, test1);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }
        try 
        {
            Utils::input_recognition(7, test2);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }
        try 
        {
            Utils::input_recognition(7, test3);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }

        const char* test4[] = {(const char*)"./main", (const char*)"P", (const char*)"-1"};
        const char* test5[] = {(const char*)"./main", (const char*)"H", (const char*)"-20"};
        const char* test6[] = {(const char*)"./main", (const char*)"C", (const char*)"dupa"};

        try 
        {
            Utils::input_recognition(3, test4);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }
        try 
        {
            Utils::input_recognition(3, test5);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }
        try 
        {
            Utils::input_recognition(3, test6);
            assert(false);
        } catch (const std::invalid_argument& e) {
            assert(true);
        }
    }
}

