//
// Created by 강병진 on 25. 5. 12.
#include <stdio.h>
#include <string.h>
struct user
{
    char name[20];
    char phone[14];
    int quick;
};
int p_13(void)
{
    struct user d;
    strcpy(d.name, "김명환");
    strcpy(d.phone, "011-123-4567");
    d.quick = 1;
    printf("name  : %s\n", d.name);
    printf("phone : %s\n", d.phone);
    printf("quick : %d\n", d.quick);
    return 0;
}
