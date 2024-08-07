#include <stdio.h>

int add(int i, int j) {
    int res = 0;
    __asm("ADD %d[result], %d[input_i], %d[input_j]"
          : [result] "=r"(res)
          : [input_i] "r"(i), [input_j] "r"(j));
    return res;
}

int main(void) {
    int a = 1;
    int b = 2;
    int c = 0;

    c = add(a, b);

    // Result of 1 + 2 = 3
    printf("Result of %d + %d = %d\n", a, b, c);
}
