#include <iostream>
#include <string>

// std::string is more recommended.
int main() {
    char you[] = "Subscriber";

    char copy2[11];
    // error: array type 'char[11]' is not assignable
    // copy2 = you;

    strcpy(copy2, you);
    std::cout << copy2 << std::endl;

    return 0;
}