#include <stdio.h>

// Source: https://youtu.be/mnqU9YdjX_c

int main(int argc, char **argv) {
    int x;
    // warning: format specifies type 'int *'
    // but the argument has type 'int'
    // scanf("%d", x);
    scanf("%d", &x);
    printf("%d\n", x);

    return 0;
}