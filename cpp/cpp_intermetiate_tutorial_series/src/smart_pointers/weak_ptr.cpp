#include <iostream>
#include <memory>

std::shared_ptr<int> get_data() {
    auto a = std::make_shared<int>(5);
    return a;
}

int main() {
    auto b = get_data();

    std::weak_ptr<int> weak = b;
    std::cout << b.use_count() << std::endl;  // 1

    // try to access it --> create a shared pointer from it
    auto shared = weak.lock();
    // check the shared pointer
    if (shared) {
        std::cout << *shared << std::endl;
    }

    return 0;
}