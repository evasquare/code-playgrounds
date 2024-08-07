#include <iostream>
#include <memory>

std::shared_ptr<int> get_data() {
    auto a = std::make_shared<int>(5);
    return a;
}

int main() {
    auto b = get_data();
    auto c = b;

    std::cout << b.use_count() << std::endl;  // 2

    return 0;
}