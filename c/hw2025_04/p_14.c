//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
struct user{
    char name[20];
    char phone[14];
    int quick;
};
void display_st(struct user data);
int p_14(void){
    struct user d={"김명환",
                 "011-123-4567",
             1};
    printf("sizeof(d) = %d\n",sizeof(d));
    display_st(d);
    return 0;
}
void display_st(struct user data){
    printf("sizeof(data) = %d\n",sizeof(data));
    printf("name  : %s\n", data.name);
    printf("phone : %s\n", data.phone);
    printf("quick : %d\n", data.quick);
}
