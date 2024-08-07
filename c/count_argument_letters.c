#include <stdio.h>
#include <string.h>

void fill_in_letter_array(char letter_array[100], int *letters_max_index, int argc, char **argv) {
    for (int i = 0; i < argc; i++) {
        if (i == 0) {
            continue;
        }

        if (i != argc - 1) {
            letter_array[*letters_max_index + 1] = ' ';
            (*letters_max_index)++;
        }

        char *current_string = argv[i];
        for (int i = 0; i < strlen(current_string); i++) {
            letter_array[*letters_max_index + 1] = current_string[i];
            (*letters_max_index)++;
        }
    }
}

#define COUNTING_LETTER 'T'
int main(int argc, char **argv) {
    // split letters
    char letter_array[100] = {0};
    int letters_max_index = -1;
    fill_in_letter_array(letter_array, &letters_max_index, argc, argv);

    // count letters
    int letter_count = 0;
    for (int i = 0; i < letters_max_index + 1; i++) {
        if (letter_array[i] == COUNTING_LETTER) {
            letter_count++;
        }
    }

    // Print the number of the letter
    printf("letter_count: %d\n", letter_count);
}

// gcc main.c -o main && ./main HELLO HELLO TEST TEST IM TESTING
// Output: VALUE : 6