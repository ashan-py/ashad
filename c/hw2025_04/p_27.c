#include <stdio.h>
//
// Created by 강병진 on 25. 5. 12.
//
struct student {
    unsigned sex : 1;
    unsigned grade : 2;
    unsigned class : 1;
    unsigned major : 4;
    unsigned PC :1 ;
    char name[16];
};
int p_27(void) {
    struct student s;
    printf("struct's size: %zu",sizeof(s));
}