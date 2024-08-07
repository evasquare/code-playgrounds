#include <iostream>
#include <vector>

int main() {
    std::vector<int> data = {1, 2, 3, 4, 5};
    data.push_back(10);

    std::cout << data[5] << std::endl;  // 10

    return 0;
}