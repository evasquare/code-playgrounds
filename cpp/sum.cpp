#include <iostream>

// Code Source: https://youtu.be/sGjAe6y299g?t=127

int sum(const int xs[], const uint length) {
    if (length == 0) {
        return 0;
    }

    return xs[length - 1] + sum(xs, length - 1);
}

int main() {
    int arr[5] = {1, 2, 3, 4, 5};
    int result = sum(arr, 5);

    std::cout << "result: " << result << std::endl;

    return 0;
}