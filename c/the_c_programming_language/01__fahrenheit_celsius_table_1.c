#include <stdio.h>

int main() {
    int fahr, celsius;
    int lower, upper, step;

    lower = 0;    // lower limit of temperature table
    upper = 300;  // upper limit
    step = 20;    // step size

    fahr = lower;

    while (fahr <= upper) {
        /*
        °C = (°F - 32) × 5/9

        The reason for multiplying by 5 and then dividing by 9
        instead of just multiply- ing by 5/9 is that in C,
        as in many other languages, integer division truncates:
        any fractional part is discarded. Since 5 and 9 are integers,
        5/9 would be truncated to zero and so all the Celsius
        temperatures would be reported as zero.
        */
        celsius = 5 * (fahr - 32) / 9;
        printf("%d\t%d\n", fahr, celsius);
        fahr = fahr + step;
    }

    return 0;
}