#include <iostream>
#include <vector>

class User {
   public:
    std::string name;
};

int main() {
    User u;
    u.name = "John Doe";
    std::cout << u.name << std::endl;

    return 0;
}