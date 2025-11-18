#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

typedef struct studentTag {
    char name[10]; // 문자배열로 된 이름
    int age;       // 나이를 나타내는 정수값
    double gpa;    // 평균평점을 나타내는 실수값
} student;

int main(void) {
    student *p;
    size_t total=0, size=sizeof(student)*1000000000;
    for (int i = 1; i < 350000; i++) {
        p = (student *) malloc(size);
        if (p == NULL) {
            fprintf(stderr, "메모리가 부족해서 할당할 수 없습니다.\n");
            fprintf(stderr, "%d번째에서 %zu바이트 할당됨\n", i, total);
            exit(1);
        }

        strcpy(p->name, "Park");
        p->age = 20;
        total += size;
    }

    free(p);
    return 0;
}