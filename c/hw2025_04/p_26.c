//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
struct patient {
    char age;
    unsigned sex : 1;
    unsigned drinking : 1;
    unsigned smoking : 1;
    unsigned marriage : 1;
};
int p_26(void) {
    struct patient a = {24,0,1,1,0};
    printf("age :%d\n", a.age);
    printf("sex :%s\n", a.sex ? "여자": "남자");
    printf("drinking :%s\n", a.drinking ? "음주자" : "비음주자");
    printf("smoking :%s\n", a.smoking ? "흡연자" : "비흡연자");
    printf("결혼 상태: %s\n", a.marriage ? "기혼자" : "미혼자");
    return 0;
}