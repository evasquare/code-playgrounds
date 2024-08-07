#include <iostream>
#include <vector>

class User {
   public:
    std::string name;
};

int main() {
    User *u = new User();
    // (*u).name = "John Doe";
    u->name = "John Doe";
    std::cout << u->name << std::endl;

    delete u;
    return 0;
}