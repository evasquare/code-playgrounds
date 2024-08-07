#include <iostream>
#include <string>

int main() {
    char you[] = "Subscriber";
    std::cout << you << " " << strlen(you) << " characters long" << std::endl;

    // error: invalid operands to binary expression
    // you += " forever";

    return 0;
}