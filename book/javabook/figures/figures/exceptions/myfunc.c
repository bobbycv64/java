
#include <stdio.h>

int myfunc(int value) {
    if (value == 4) {
        return 0;
    }
    return 1;
}

int main() {
    int error = myfunc(4);
    if (error != 0) {
        /* handle problem */
        printf("myfunc problem\n");
    }
    /* continue */
    printf("myfunc okay\n");
    error = myfunc(3);
    if (error != 0) {
        printf("myfunc problem\n");
    }
    return 0;
}
