#include <testrun.hpp>

#include <cassert>
#include <stdexcept>

#include <pascal.hpp>
#include <convert.hpp>
#include <newton.hpp>

void TestRun::run_all()
{
    run_convert();
    run_pascal();
}

void TestRun::run_convert()
{
    {
    assert(Convert::string_to<long int>("1") == 1);
    assert(Convert::string_to<long int>("0") == 0);
    assert(Convert::string_to<long int>("19129") == 19129);
    assert(Convert::string_to<long int>("-12") == -12);
    assert(Convert::string_to<long int>("-34383") == -34383);
    assert(Convert::string_to<long int>("3388") == 3388);
    }

    try
    {
        Convert::string_to<long int>("dupa");

        assert(false); //gdyby się nie wywaliło - to tu się wywali
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

    try
    {
        Convert::string_to<long int>("-dup10a");

        assert(false); //gdyby się nie wywaliło - to tu się wywali
    }
    catch (const std::invalid_argument& e)
    {
        assert(true);
    }

}

void TestRun::run_pascal()
{
    {
    Pascal test_pascal(4);

    assert(test_pascal[0] == 1);
    assert(test_pascal[1] == 4);
    assert(test_pascal[2] == 6);
    assert(test_pascal[3] == 4);
    assert(test_pascal[4] == 1);
    }
    
    try 
    {
        Pascal test_pascal(15);

        test_pascal[16];

        assert(false);
    }
    catch (const std::out_of_range& c)
    {
        assert(true);
    }

    try 
    {
        Pascal test_pascal(10);

        test_pascal[16];

        assert(false);
    }
    catch (const std::out_of_range& c)
    {
        assert(true);
    }

    try 
    {
        Pascal test_pascal(20);

        test_pascal[-16];

        assert(false);
    }
    catch (const std::out_of_range& c)
    {
        assert(true);
    }
}
