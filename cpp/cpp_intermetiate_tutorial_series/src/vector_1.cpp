#include <iostream>

void work(int &x) { x++; }
void work(std::vector<int> data) { data[0] = 10000; }

int main() {
    std::vector<int> data = {10, 11};

    std::cout << data[0] << std::endl;
    work(data);
    std::cout << data[0] << std::endl;

    return 0;
}