//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
struct person
{
    const char *name;
    int age;
    struct phone
    {
        const char *home_num;
        const char *mobile_num;
    } number;
};
int p_16(void)
{
    struct person man, *pt;
    pt = &man;
    pt->name = "jaeho";
    pt->age = 18;
    pt->number.home_num = "02-345-0084";
    pt->number.mobile_num = "019-945-0001";
    printf("name   : %s\n", pt->name);
    printf("age    : %d\n", pt->age);
    printf("home   : %s\n", pt->number.home_num);
    printf("mobile : %s\n", pt->number.mobile_num);
    printf("\n");
    printf("man.\n");
    printf("name   : %s\n", man.name);
    printf("age    : %d\n", man.age);
    printf("home   : %s\n", man.number.home_num);
    printf("mobile : %s\n", man.number.mobile_num);
    return 0;
}
