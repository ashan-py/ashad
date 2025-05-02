//
// Created by 강병진 on 25. 4. 20.
//
#include <stdio.h>
#define SQUARE(x) x*x
int main(void) {
    printf("%d,%d\n", SQUARE(9), SQUARE(5+4));
    return 0;
}