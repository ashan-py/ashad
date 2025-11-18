#include <stdio.h>
//
// Created by 강병진 on 25. 9. 19.
//
typedef struct person {
    char name[10];
    int age;
    float height;
}person;

int main(void) {
    person p;
    printf("%d\n",&p.name);
    printf("%d\n",&p.age);
    printf("%d\n",&p.height);
    printf("%lu\n",sizeof(person));
}