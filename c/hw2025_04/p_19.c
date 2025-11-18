#include <stdio.h>
//
// Created by 강병진 on 25. 5. 12.
//
struct com {
    char name[20];
    int price;
    int num;
};
int p_19(void) {
    int sum = 0;
    struct com a[5] = {
        {"hard disk", 135000, 5},
        {"CPU", 235000, 7},
        {"main board", 162000, 9},
        {"monitor", 260000, 4},
        {"DVD-RW", 73500, 6}
    };
    for (int i = 0; i < 5; i++) {
        int m = a[i].price * a[i].num;
        printf("품명: %s 단가: %d 수량: %d 금액: %d\n", a[i].name,a[i].price,a[i].num, m);
        sum += m;
    }
    printf("총합: %d", sum);
}