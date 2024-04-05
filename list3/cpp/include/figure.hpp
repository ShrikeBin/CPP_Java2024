#ifndef FIGURE_HPP
#define FIGURE_HPP

class Figure 
{   
public:
    virtual ~Figure(){}

public:
    virtual double area() = 0;
    virtual double length() = 0;
};

#endif