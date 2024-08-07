#include <iostream>
#include <string>

int main() {
    std::string name = "Caleb";
    name += " Curry";

    std::cout << name << std::endl;

    std::cin >> name;
    std::cout << name << std::endl;  // Caleb Curry

    return 0;
}