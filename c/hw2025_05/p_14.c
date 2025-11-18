#include <stdio.h>

int main(void) {
    int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int n = sizeof(a) / sizeof(int); // 요소 개수 구하기
    int key, i, l, h, m;

    printf("Current Data \n\n");
    for (i = 0; i < n; i++) {
        printf("%4d", a[i]);
    }
    printf("\n\n");
    printf("Input key: ");
    scanf("%d", &key);
    // h = n;
    // l = 1;
    // i = 0;
    h = n-1;
    l = 0;
    i = -1;


    while (l <= h) {
        m = (l + h) / 2;
        if (key < a[m])
            h = m - 1;
        else if (key > a[m])
            l = m + 1;
        else {
            i = m;
            printf("Find Data %d (index %d)\n", a[m], m);
            break;
        }
    }

    if (i == -1)
        printf("%d is not exist.\n", key);

    return 0;
}