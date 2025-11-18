//
// Created by 강병진 on 25. 5. 12.
//
#include <stdio.h>
enum prod {engine=3, battery, filter, fuse};
int p_24(void)
{
    enum prod v;
    v=battery;
    printf("장치번호 : %d\n", v);
    printf("engine 번호 : %d\n", engine);
    v=fuse;
    printf("장치번호 : %d\n", v);
    return 0;
}
