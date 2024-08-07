#include <iostream>
#include <string>

int main() {
    std::string name = "Caleb";
    std::cout << name.size() << std::endl;  // 5
    name += " Curry";

    std::cout << name << std::endl;  // Caleb Curry

    return 0;
}