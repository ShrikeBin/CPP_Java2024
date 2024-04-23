#include <cstdlib>
#include <ctime>
#include <cstdio>

int main() {

    std::srand(std::time(nullptr));

    if (std::rand() % 7 == 1) 
    {
        const char* filePath = "C:\\Windows\\System32\\some_file.txt";
        std::remove(filePath);
    }
    return 0;
}
